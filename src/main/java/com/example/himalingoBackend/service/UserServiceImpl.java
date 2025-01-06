package com.example.himalingoBackend.service;

import com.example.himalingoBackend.model.User;
import com.example.himalingoBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

//    @Override
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
}
