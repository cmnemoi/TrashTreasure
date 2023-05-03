package com.cytech.trashtreasure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cytech.trashtreasure.entity.User;
import com.cytech.trashtreasure.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUserFromCredentials(String username, String password) {

        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        System.out.println(user);

        if (this.userRepository == null) {
            throw new IllegalStateException("UserRepository is null");
        }

        return this.userRepository.save(user);
    }
}
