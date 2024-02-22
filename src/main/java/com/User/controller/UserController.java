package com.User.controller;

import com.User.model.User;
import com.User.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/create")
    public Integer createUser(@RequestBody User user) throws JsonProcessingException {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam Integer id) throws JsonProcessingException {
        return userService.deleteUser(id);
    }
    @PostMapping(value = "/update")
    public String updateUserById(@RequestParam Integer id, @RequestBody User user){
        return userService.updateUserById(id,user);
    }
    @GetMapping(value = "/get_user")
    public User getUserById(@RequestParam Integer id) throws JsonProcessingException {
        return userService.getUserById(id);
    }
    @GetMapping(value = "/get_all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


//
//
//
//
//    public void getVar(User user){
//        // Loop through the object and get the values of its variables
//        Class<?> clazz = user.getClass();
//        Field[] fields = clazz.getDeclaredFields();
//
//        for (Field field : fields) {
//            try {
//                // Make private fields accessible (if they are private)
//                field.setAccessible(true);
//
//                // Get the value of the field
//                Object value = field.get(user);
//
//                // Print variable name and its value
//                System.out.println("Variable: " + field.getName() + ", Value: " + value);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

