package com.trekfolio.service;

import com.trekfolio.entity.User;
import com.trekfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.trekfolio.dto.LoginResponse;
import com.trekfolio.security.JwtService;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public User registerUser(User user) {

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public LoginResponse loginUser(String email, String password){

        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid Password");

        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token, "Login Successful");    }

}