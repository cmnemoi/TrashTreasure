package com.cytech.trashtreasure.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cytech.trashtreasure.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void createUserFromCredentialsTest() {
        // generate dynamic username and password
        String username = String.valueOf(System.currentTimeMillis());
        String password = String.valueOf(System.currentTimeMillis());

        userService.createUserFromCredentials(username, password);

        assertNotNull(userRepository.findByUsername(username), "User should be found in repository");

    }

    @Test
    void loginUsingCredentialsTest() {
        // generate dynamic username and password
        String username = String.valueOf(System.currentTimeMillis());
        String password = String.valueOf(System.currentTimeMillis());

        userService.createUserFromCredentials(username, password);

        assertNotNull(userService.loginUsingCredentials(username, password), "loginUsingCredentials should return connected user");

    }
}
