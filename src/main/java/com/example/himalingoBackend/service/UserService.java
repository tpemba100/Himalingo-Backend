package com.example.himalingoBackend.service;

import com.example.himalingoBackend.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
    public void save(UserDTO userDTO);
//    public UserDTO findUserByEmail(String email);
}
