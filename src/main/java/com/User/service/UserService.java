package com.User.service;

import com.User.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface UserService {
    Integer createUser(User user) throws JsonProcessingException;
    Integer deleteUser(Integer id);
    String updateUserById(Integer id, User user) throws IllegalAccessException;
    User getUserById(Integer id) throws JsonProcessingException;
    List<User> getAllUsers();
}
