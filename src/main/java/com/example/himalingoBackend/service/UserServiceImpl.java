package com.example.himalingoBackend.service;

import com.example.himalingoBackend.dto.UserDTO;
import com.example.himalingoBackend.model.User;
import com.example.himalingoBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public void save(UserDTO userDTO) {
        // Check if user exists by email (optional, if you want to avoid duplicate entries)
//         if (userRepository.findByEmail(userDTO.getEmail()) != null) {
//            throw new RuntimeException("User with email: " + userDTO.getEmail() + " already exists");
//        }

        // Create a new User object and set the properties from UserDTO
        User user = new User();
        user.setEmail(userDTO.getEmail());  // User's email
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));  // Encrypt password
        user.setUserName(userDTO.getUserName());  // User's username
        user.setRole(userDTO.getRole());  // Assign the role (USER or ADMIN)

        // Save the user into the database
        userRepository.save(user);
    }

}
