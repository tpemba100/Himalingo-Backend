package com.example.himalingoBackend.controller;

import com.example.himalingoBackend.dto.UserDTO;
import com.example.himalingoBackend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new UserDTO());
        return "signup";
    }

    @PostMapping("/signup-process")
    public String signUpUser(@ModelAttribute UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/login";
    }
}
