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
    public Button claimVoucherButton;
    @FXML
    public Button depositButton;
    @FXML
    public Button watchDepositButton;

    private final FxControllerAndView<ClaimVoucherController, VBox> claimVoucherController;
    private final FxControllerAndView<DepositsController, VBox> depositsController;
    private final FxControllerAndView<TrashController, VBox> trashController;

    public HomeController(
        FxControllerAndView<ClaimVoucherController, VBox> claimVoucherController,
        FxControllerAndView<DepositsController, VBox> depositsController,
        FxControllerAndView<TrashController, VBox> trashController
    ) {
        this.claimVoucherController = claimVoucherController;
        this.depositsController = depositsController;
        this.trashController = trashController;
    }

    @FXML
    public void initialize() {
        claimVoucherButton.setOnAction(actionEvent -> {
            goToClaimVoucherView();
        });
        depositButton.setOnAction(actionEvent -> {
            goToDepositView();
        });
        watchDepositButton.setOnAction(actionEvent -> {
            goToWatchDepositsView();
        });
    }

    private void goToClaimVoucherView() {
        claimVoucherController.getController().setConnectedUser(connectedUser);
        claimVoucherController.getController().show(getCurrentScene());
    }

    private void goToDepositView() {
        trashController.getController().setConnectedUser(connectedUser);
        trashController.getController().show(getCurrentScene());
    }

    private void goToWatchDepositsView() {
        depositsController.getController().setConnectedUser(connectedUser);
        depositsController.getController().show(getCurrentScene());
    }
}
