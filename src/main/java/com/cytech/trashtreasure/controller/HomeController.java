package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("HomeView.fxml")
public class HomeController extends AbstractController {
    
    @FXML
    private Label fidelityPointsLabel;
    @FXML
    private Label usernameLabel;
    
    protected void updateScene() {
        usernameLabel.setText(connectedUser.getUsername());
        fidelityPointsLabel.setText(
            "Points : " +
            connectedUser.getFidelityPoints().toString()
        );
    }

}
