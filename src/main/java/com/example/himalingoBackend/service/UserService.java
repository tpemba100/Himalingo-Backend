package com.example.himalingoBackend.service;

import com.example.himalingoBackend.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(UserDTO userDTO);
}
