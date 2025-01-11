package com.example.himalingoBackend.repository;

import com.example.himalingoBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
//    User findByEmail(String email);
}
