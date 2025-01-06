package com.example.himalingoBackend.service;

import com.example.himalingoBackend.model.User;

public interface UserService {
    //save a new user
    public User saveUser(User user);


    public User findByUsername(String username);
}
