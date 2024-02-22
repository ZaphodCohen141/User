package com.User.service;

import com.User.model.User;
import com.User.poolMicroService.PoolController;
import com.User.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PoolController poolController;
    @Override
    public Integer createUser(User user) throws JsonProcessingException {
        String userAsString = objectMapper.writeValueAsString(user);
        System.out.println(userAsString);
        return userRepository.createUser(user);
    }

    @Override
    public String deleteUser(Integer id) throws JsonProcessingException {
//        check that the user really exists
//        if exists - send to the pool server to delete user's reply
        User user = userRepository.getUserById(id);
        if (user == null){
            return "there is no user with id " + id;

        }else{
            userRepository.deleteUser(id);
            poolController.deleteRepliesByUserId(id);
            return "user " + id + " was deleted";
        }
    }

    @Override
    public String updateUserById(Integer id, User user) {
        return userRepository.updateUserById(id,user);
    }

    @Override
    public User getUserById(Integer id) throws JsonProcessingException {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
