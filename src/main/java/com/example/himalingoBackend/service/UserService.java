
package com.example.himalingoBackend.service;


import com.example.himalingoBackend.dto.UserDTO;
import com.example.himalingoBackend.entity.User;
import com.example.himalingoBackend.repository.UsersRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//User Service Impl
// toRegister(userDTO), toLogin(userDTO), getAllUsers, getUserById(id), deleteUser(id), updateUser(id, user), getMyInfo(email)
@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDTO register(UserDTO registrationRequest){
        UserDTO resp = new UserDTO();

        try {
            User ourUser = new User();
            ourUser.setEmail(registrationRequest.getEmail());
            ourUser.setCity(registrationRequest.getCity());
            ourUser.setRole(registrationRequest.getRole());
            ourUser.setName(registrationRequest.getName());
            ourUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            User userResult = usersRepo.save(ourUser);
            if (userResult.getId()>0) {
                resp.setUser((userResult));
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }

        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }


    public UserDTO login(UserDTO loginRequest, HttpSession session) {
        UserDTO response = new UserDTO();
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            // Retrieve the user from the database
            User user = usersRepo.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Store session attributes
            session.setAttribute("userId", user.getId());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole());

            System.out.println("Session attributes set: userId=" + user.getId() +
                    ", email=" + user.getEmail() +
                    ", role=" + user.getRole());

            // Set SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(auth);

            // Set the response with user details
            response.setMessage("Successfully logged in");
            response.setId(user.getId());  // Set user ID in response
            response.setRole(user.getRole());

        } catch (Exception e) {
            response.setMessage("Invalid email or password");
        }
        return response;
    }




    // GET User DATA BY ID  --> /profile
    public UserDTO getUserById(Integer userId) {
        UserDTO userDTO = new UserDTO();
        try {
            User user = usersRepo.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            userDTO.setUser(user);
            userDTO.setMessage("User profile fetched successfully");
        } catch (Exception e) {
            userDTO.setMessage("Error occurred while getting user profile: " + e.getMessage());
        }
        return userDTO;
    }





    public UserDTO getAllUsers() {
        UserDTO userDTO = new UserDTO();

        try {
            List<User> result = usersRepo.findAll();
            if (!result.isEmpty()) {
                userDTO.setUserList(result);
                userDTO.setStatusCode(200);
                userDTO.setMessage("Successful");
            } else {
                userDTO.setMessage("No users found");
            }
            return userDTO;
        } catch (Exception e) {
            userDTO.setMessage("Error occurred: " + e.getMessage());
            return userDTO;
        }
    }


    public UserDTO getUsersById(Integer id) {
        UserDTO userDTO = new UserDTO();
        try {
            User usersById = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
            userDTO.setUser(usersById);
            userDTO.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            userDTO.setMessage("Error occurred: " + e.getMessage());
        }
        return userDTO;
    }


    public UserDTO deleteUser(Integer userId) {
        UserDTO userDTO = new UserDTO();
        try {
            Optional<User> userOptional = usersRepo.findById(userId);
            if (userOptional.isPresent()) {
                usersRepo.deleteById(userId);

                userDTO.setMessage("User deleted successfully");
            } else {
                userDTO.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            userDTO.setStatusCode(500);
            userDTO.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return userDTO;
    }

    public UserDTO updateUser(Integer userId, User updatedUser) {
        UserDTO userDTO = new UserDTO();
        try {
            Optional<User> userOptional = usersRepo.findById(userId);
            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setName(updatedUser.getName());
                existingUser.setCity(updatedUser.getCity());
                existingUser.setRole(updatedUser.getRole());

                // Check if password is present in the request
                if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                    // Encode the password and update it
                    existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                }

                User savedUser = usersRepo.save(existingUser);
                userDTO.setUser(savedUser);
                userDTO.setStatusCode(200);
                userDTO.setMessage("User updated successfully");
            } else {
                userDTO.setMessage("User not found for update");
            }
        } catch (Exception e) {

            userDTO.setMessage("Error occurred while updating user: " + e.getMessage());
        }
        return userDTO;
    }


    public UserDTO getMyInfo(String email){
        UserDTO userDTO = new UserDTO();
        try {
            Optional<User> userOptional = usersRepo.findByEmail(email);
            if (userOptional.isPresent()) {
                userDTO.setUser(userOptional.get());
                userDTO.setStatusCode(200);
                userDTO.setMessage("successful");
            } else {
                userDTO.setMessage("User not found for update");
            }

        }catch (Exception e){
            userDTO.setStatusCode(500);
            userDTO.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return userDTO;

    }
}
