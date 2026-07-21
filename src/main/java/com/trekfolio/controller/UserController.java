package com.trekfolio.controller;

import com.trekfolio.entity.User;
import com.trekfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.trekfolio.dto.LoginResponse;
import org.springframework.security.core.Authentication;

import java.util.List;
import com.trekfolio.dto.LoginRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){

        return userService.registerUser(user);

    }

    @GetMapping
    public List<User> getUsers(){

        return userService.getAllUsers();

    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        return userService.loginUser(
                request.getEmail(),
                request.getPassword());

    }
    @GetMapping("/me")
    public User getCurrentUser(Authentication authentication) {

        String email = authentication.getName();

        return userService.getUserByEmail(email);

    }

}
