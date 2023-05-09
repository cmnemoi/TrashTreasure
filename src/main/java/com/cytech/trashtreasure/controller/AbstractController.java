package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.entity.User;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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

    public void show(Scene scene) {
        scene.setRoot(root);
        updateScene();
    }

    protected Scene getCurrentScene() {
        return  root.getScene();
    }

    protected void updateScene() {
        usernameLabel.setText(connectedUser.getUsername());
        fidelityPointsLabel.setText(
            "Points : " +
            connectedUser.getFidelityPoints().toString()
        );
    }

}

