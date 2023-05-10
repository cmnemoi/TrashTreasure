package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.entity.VoucherConfig;
import com.cytech.trashtreasure.service.VoucherService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("ClaimVoucherView.fxml")
public class ClaimVoucherController extends AbstractController {

    @FXML
    public Button backButton;
    @FXML
    public Button claimButton;
    @FXML
    public ChoiceBox<VoucherConfig> voucherChoiceBox;

    private final FxControllerAndView<HomeController, VBox> homeController;

    @Autowired
    private VoucherService voucherService;

    public ClaimVoucherController(FxControllerAndView<HomeController, VBox> homeController) {
        this.homeController = homeController;
    }

    public void initialize() {
        backButton.setOnAction(actionEvent -> {
            back();
        });
        claimButton.setOnAction(actionEvent -> {
            claim();
        });
    }

    protected void updateScene() {
        super.updateScene();
        voucherChoiceBox.getItems().clear();
        voucherChoiceBox.getItems().addAll(voucherService.getAllVouchers());
    }

    private void back() {
        homeController.getController().setConnectedUser(connectedUser);
        homeController.getController().show(getCurrentScene());
    }

    private void claim() {
        VoucherConfig selectedVoucher = voucherChoiceBox.getValue();
        if (selectedVoucher.getFidelityPointsCost() > connectedUser.getFidelityPoints()) {
            showErrorMessage("Erreur", "Vous n'avez pas assez de points de fidélité pour obtenir ce bon");
            return;
        }

        voucherService.addVoucherToUser(selectedVoucher, connectedUser);
        showSuccessMessage("Succès", "Bon d'achat ajouté à votre compte");
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
