package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.entity.User;
import com.cytech.trashtreasure.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("LoginView.fxml")
public class LoginController {

    @FXML
    public Button loginButton;
    @FXML
    public Button registerButton;
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;

    private final FxControllerAndView<HomeController, VBox> homeController;
    @Autowired
    private UserService userService;

    public LoginController(FxControllerAndView<HomeController, VBox> homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void initialize() {        
        loginButton.setOnAction(actionEvent -> {
            login();
        });
        registerButton.setOnAction(actionEvent -> {
            register();
        });
    }

    private Scene getCurrentScene() {
        return loginButton.getScene();
    }

    private void login() {
        try {
            User connectedUser = userService.loginUsingCredentials(usernameField.getText(), passwordField.getText());
            showSuccessMessage("Connexion réussie", "Vous êtes maintenant connecté");

            // give the home controller the user so it can retrieve its data
            homeController.getController().setConnectedUser(connectedUser);

            // send the scene to the home controller so we can switch windows
            homeController.getController().show(getCurrentScene());

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
