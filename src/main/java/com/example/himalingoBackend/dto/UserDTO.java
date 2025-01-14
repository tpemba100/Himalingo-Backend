package com.example.himalingoBackend.dto;

import com.example.himalingoBackend.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

//User DTO

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private int statusCode;
    private int id;
    private String error;
    private String message;

    private String name;
    private String city;
    private String role;
    private String email;
    private String password;
    private User user;
    private List<User> userList;

}
