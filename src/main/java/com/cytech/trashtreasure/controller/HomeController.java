package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("HomeView.fxml")
public class HomeController extends AbstractController {
    
    @FXML
    public Button convertPointsButton;
    @FXML
    public Button depositButton;
    @FXML
    public Button watchDepositButton;

    private final FxControllerAndView<DepositController, VBox> depositController;

    public HomeController(FxControllerAndView<DepositController, VBox> depositController) {
        this.depositController = depositController;
    }

    @FXML
    public void initialize() {
        convertPointsButton.setOnAction(actionEvent -> {
            goToConvertPointsView();
        });
        depositButton.setOnAction(actionEvent -> {
            goToDepositView();
        });
        watchDepositButton.setOnAction(actionEvent -> {
            goToWatchDepositsView();
        });
    }

    private void goToConvertPointsView() {
        // TODO
    }

    private void goToDepositView() {
        depositController.getController().setConnectedUser(connectedUser);
        depositController.getController().show(getCurrentStage());
    }

    private void goToWatchDepositsView() {
        // TODO
    }
}
