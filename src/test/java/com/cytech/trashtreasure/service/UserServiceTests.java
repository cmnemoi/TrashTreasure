package com.cytech.trashtreasure.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
    
    @Test
    void createUserFromCredentialsTest() {
        String username = "username";
        String password = "password";

        UserService userService = new UserService();

        userService.createUserFromCredentials(username, password);
    }
}
