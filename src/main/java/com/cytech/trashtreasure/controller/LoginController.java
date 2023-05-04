package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.service.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
            
            // send the stage to the home controller so we can switch to it
            Stage stage = (Stage) loginButton.getScene().getWindow();
            homeController.getController().show(stage);
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
