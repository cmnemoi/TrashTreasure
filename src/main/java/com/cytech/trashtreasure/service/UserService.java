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
            throw new IllegalArgumentException("Le nom d'utilisateur ne peut pas être vide");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");
        }
        if (userAlreadyExists(username)) {
            throw new IllegalArgumentException("L'utilisateur " + username + " existe déjà");
        }
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }

    public User loginUsingCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("L'utilisateur " + username + " n'existe pas"); 
        }
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Le mot de passe est incorrect");
        }
        return user;
    }

    private boolean userAlreadyExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
