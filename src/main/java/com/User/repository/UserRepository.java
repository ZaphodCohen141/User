package com.User.repository;

import com.User.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface UserRepository {
    Integer createUser(User user);
    Integer deleteUser(Integer id);
    String updateUserById(Integer id, User user);
    User getUserById(Integer id) throws JsonProcessingException;
    List<User> getAllUsers();
}
