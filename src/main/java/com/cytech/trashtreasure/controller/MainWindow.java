package com.cytech.trashtreasure.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import org.springframework.stereotype.Component;

import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView
public class MainWindow {

    private final FxControllerAndView<SomeDialog, VBox> someDialog;

    @FXML
    public Button openDialogButton;

    public MainWindow(FxControllerAndView<SomeDialog, VBox> someDialog) {
        this.someDialog = someDialog;
    }

    @FXML
    public void initialize() {
        openDialogButton.setOnAction(
                actionEvent -> someDialog.getController().show()
        );
    }

}