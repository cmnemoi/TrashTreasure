package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("HomeView.fxml")
public class HomeController {
    

    @FXML
    private VBox root;

    @FXML
    public void initialize() {
    }

    public void show(Stage stage) {
        stage.setScene(new Scene(root));
        stage.show();
    }
}
