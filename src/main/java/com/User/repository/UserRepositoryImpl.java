package com.User.repository;


import com.User.model.User;
import com.User.model.Util;
import com.User.repository.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Integer createUser(User user) {
        String sql = "INSERT INTO "
                + Util.USER_TABLE_NAME +
                " (first_name,last_name,email,age,address,join_date)" +
                " VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getAge(), user.getAddress(), user.getDate());
        sql = "SELECT MAX(id) FROM " + Util.USER_TABLE_NAME;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM " + Util.USER_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql, id);
        if (jdbcTemplate.update(sql, id) == 1) {
            System.out.println("user " + id + " was deleted");
        } else {
            System.out.println("no user was deleted");
        }
    }

    @Override
    public String updateUserById(Integer id, User user) {
        String sql = "UPDATE " + Util.USER_TABLE_NAME + " SET" + StringUserNotNullVar(user) + "WHERE id = ?";
        Integer update = jdbcTemplate.update(sql,id);
        if (update == 1){
            return "user with id " + id + " was updated";
        }else {
            return "no such user";
        }
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM " + Util.USER_TABLE_NAME + " WHERE id = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM " + Util.USER_TABLE_NAME;
        return jdbcTemplate.query(sql, new UserMapper());
    }





    public String StringUserNotNullVar(User user) {
        // Loop through the object and get the values of its variables
        Field[] fields = user.getClass().getDeclaredFields();
        String[] dbNames = {"id","first_name", "last_name", "email", "age", "address", "join_date"};
        ArrayList<String> values = new ArrayList<>();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(user);
                if (value!=null) {
                    values.add(value.toString());
                }else {
                    values.add("null");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String valuesAsArray[] = new String[dbNames.length];
        valuesAsArray = values.toArray(valuesAsArray);
        ArrayList<String> concateDbValues = new ArrayList<>();
        for (int i = 0; i < dbNames.length; i++) {
            if (i == 0) {
                concateDbValues.add("SET " + dbNames[i] + " = '" + valuesAsArray[i] +"'");
            }else {
                concateDbValues.add(dbNames[i] + " = '" + valuesAsArray[i]+"'");
            }
        }
//    remove null values;
        for (int i = 0; i < concateDbValues.size(); i++) {
            if (concateDbValues.get(i).contains("null")){
                concateDbValues.remove(i);
            }
        }
        String fin = " ";
        for (int i = 0; i < concateDbValues.size(); i++) {
            if(i == concateDbValues.size()-1){
                fin = fin + concateDbValues.get(i) + " ";
            }else {
                fin = fin + concateDbValues.get(i) + ", ";
            }
        }
        return fin;
    }


}

