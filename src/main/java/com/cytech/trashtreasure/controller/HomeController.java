package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("HomeView.fxml")
public class HomeController {

    @Autowired
    private UserService userService;

    // Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    Button loginButton;
    @FXML
    Button registerButton;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;

    @FXML
    public void initialize() {
        loginButton.setOnAction(actionEvent -> {
            login();
        });
        registerButton.setOnAction(actionEvent -> {
            register();
        });
    }

    private void login() {
        try {
            userService.loginUsingCredentials(usernameField.getText(), passwordField.getText());
            showSuccessMessage("Connexion réussie", "Vous êtes maintenant connecté");
        } catch (IllegalArgumentException error) {
            showErrorMessage("Erreur lors de la connexion", error.getMessage());
        }

    }

    private void register() {
        try {
            userService.createUserFromCredentials(usernameField.getText(), passwordField.getText());
            showSuccessMessage("Inscription réussie", "Vous pouvez maintenant vous connecter");
        } catch (IllegalArgumentException error) {
            showErrorMessage("Erreur lors de l'inscription", error.getMessage());
        }

    }

    private void showErrorMessage(String errorHeader, String errorContent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(errorHeader);
        alert.setContentText(errorContent);
        alert.showAndWait();
    }

    private void showSuccessMessage(String successHeader, String successContent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(successHeader);
        alert.setContentText(successContent);
        alert.showAndWait();
    }
}
