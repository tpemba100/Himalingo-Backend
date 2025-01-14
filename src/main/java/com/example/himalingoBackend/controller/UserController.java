
package com.example.himalingoBackend.controller;

import com.example.himalingoBackend.dto.UserDTO;
import com.example.himalingoBackend.entity.User;
import com.example.himalingoBackend.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO reg){
        return ResponseEntity.ok(userService.register(reg));
    }


    //Login & logout using Session based
    @PostMapping("/auth/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO loginRequest, HttpSession session){
        UserDTO response = userService.login(loginRequest, session);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    //LOG OUT
    @PostMapping("/auth/logout")
    public ResponseEntity<UserDTO> logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        UserDTO response = new UserDTO();
        response.setStatusCode(200);
        response.setMessage("Successfully logged out");
        return ResponseEntity.ok(response);
    }

    // User Data for /profile
    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<UserDTO> getMyProfile(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        System.out.println(userId);
        if (userId == null) {
            UserDTO response = new UserDTO();
            response.setStatusCode(401);
            response.setMessage("Unauthorized: Please log in.");
            return ResponseEntity.status(401).body(response);
        }

        UserDTO response = userService.getUserById(userId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


    @GetMapping("/admin/get-all-users")
    public ResponseEntity<UserDTO> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());

    }

    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<UserDTO> getUSerByID(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getUserById(userId));

    }

    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userId, @RequestBody User reqres){
        return ResponseEntity.ok(userService.updateUser(userId, reqres));
    }


    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<UserDTO> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }


}
