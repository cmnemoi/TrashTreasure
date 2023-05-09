package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.entity.User;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
abstract public class AbstractController {
    
    @FXML
    private Label fidelityPointsLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    protected VBox root;

    protected User connectedUser;

    @FXML
    abstract public void initialize();

    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }

    public void show(Stage stage) {
        stage.setScene(new Scene(root));
        updateScene();
        stage.show();
    }

    protected Stage getCurrentStage() {
        return (Stage) root.getScene().getWindow();
    }

    protected void updateScene() {
        usernameLabel.setText(connectedUser.getUsername());
        fidelityPointsLabel.setText(
            "Points : " +
            connectedUser.getFidelityPoints().toString()
        );
    }

}

