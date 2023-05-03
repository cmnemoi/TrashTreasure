package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("HomeView.fxml")
public class HomeController {

    @Autowired
    private UserService userService;

    @FXML
    Button loginButton;
    @FXML
    Button registerButton;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;

    private void register() {
        this.userService.createUserFromCredentials(usernameField.getText(), passwordField.getText());
    }

    @FXML
    public void initialize() {
        registerButton.setOnAction(e -> {
            register();
        });
    }
}
