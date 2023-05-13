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
    @FXML
    public Button watchStatsButton;
    @FXML
    public Button watchVouchersButton;

    private final FxControllerAndView<ClaimVoucherController, VBox> claimVoucherController;
    private final FxControllerAndView<DepositsController, VBox> depositsController;
    private final FxControllerAndView<StatsController, VBox> statsController;
    private final FxControllerAndView<TrashController, VBox> trashController;
    private final FxControllerAndView<VouchersController, VBox> vouchersController;

    public HomeController(
        FxControllerAndView<ClaimVoucherController, VBox> claimVoucherController,
        FxControllerAndView<DepositsController, VBox> depositsController,
        FxControllerAndView<StatsController, VBox> statsController,
        FxControllerAndView<TrashController, VBox> trashController,
        FxControllerAndView<VouchersController, VBox> vouchersController
    ) {
        this.claimVoucherController = claimVoucherController;
        this.depositsController = depositsController;
        this.statsController = statsController;
        this.trashController = trashController;
        this.vouchersController = vouchersController;
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
        watchStatsButton.setOnAction(actionEvent -> {
            goToWatchStatsView();
        });
        watchVouchersButton.setOnAction(actionEvent -> {
            goToWatchVouchersView();
        });
    }

    protected void updateScene() {
        super.updateScene();
        if (!connectedUser.isAdmin()) {
            watchStatsButton.setVisible(false);
        }
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

    private void goToWatchStatsView() {
        statsController.getController().setConnectedUser(connectedUser);
        statsController.getController().show(getCurrentScene());
    }

    private void goToWatchVouchersView() {
        vouchersController.getController().setConnectedUser(connectedUser);
        vouchersController.getController().show(getCurrentScene());
    }
}
