package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.entity.Trash;
import com.cytech.trashtreasure.service.TrashService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("TrashView.fxml")
public class TrashController extends AbstractController {

    @FXML
    public Button backButton;
    @FXML
    public Button trashButton;
    @FXML
    public ChoiceBox<String> binChoiceBox;
    @FXML
    public ChoiceBox<String> trashChoiceBox;
    @FXML
    public Spinner<Integer> trashQuantitySpinner;

    @Autowired
    private TrashService trashService;

    private final FxControllerAndView<HomeController, VBox> homeController;

    public TrashController(FxControllerAndView<HomeController, VBox> homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void initialize() {
        backButton.setOnAction(actionEvent -> {
            back();
        });
        trashQuantitySpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1)
        );
        trashButton.setOnAction(actionEvent -> {
            trash();
            updateScene();
        });
    }

    protected void updateScene() {
        super.updateScene();

        binChoiceBox.getItems().clear();
        binChoiceBox.getItems().addAll(trashService.getAllBinNames());
        binChoiceBox.getSelectionModel().selectFirst();

        trashChoiceBox.getItems().clear();
        trashChoiceBox.getItems().addAll(trashService.getAllTrashNames());
        trashChoiceBox.getSelectionModel().selectFirst();
    }

    private void back() {
        homeController.getController().setConnectedUser(connectedUser);
        homeController.getController().show(getCurrentScene());
    }

    private void showSuccessMessage(String successHeader, String successContent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(successHeader);
        alert.setContentText(successContent);
        alert.showAndWait();
    }

    private void trash() {
        String selectedTrash = trashChoiceBox.getSelectionModel().getSelectedItem();
        Integer selectedQuantity = trashQuantitySpinner.getValue();
        String selectedBin = binChoiceBox.getSelectionModel().getSelectedItem();

        Trash depositedTrash = trashService.putTrashIntoBin(
            selectedTrash,
            selectedQuantity,
            selectedBin,
            connectedUser
        );

        showSuccessMessage(
            "Dépôt effectué",
            "Votre dépôt a bien été effectué. Vous avez gagné " + depositedTrash.getEarnedPoints() + " points !"
        );
    }

    

}