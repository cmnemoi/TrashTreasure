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
        // generate random username and password
        String username = String.valueOf(System.currentTimeMillis());
        String password = String.valueOf(System.currentTimeMillis());

        userService.createUserFromCredentials(username, password);

        assertNotNull(userRepository.findByUsername(username), "User should be found in repository");

    }
}
