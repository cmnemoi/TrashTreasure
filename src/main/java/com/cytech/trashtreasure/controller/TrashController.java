package com.cytech.trashtreasure.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.entity.Bin;
import com.cytech.trashtreasure.entity.TrashConfig;
import com.cytech.trashtreasure.repository.BinRepository;
import com.cytech.trashtreasure.repository.TrashConfigRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    
    @Autowired
    private BinRepository binRepository;
    @Autowired
    private TrashConfigRepository trashConfigRepository;

    private final FxControllerAndView<HomeController, VBox> homeController;

    public TrashController(FxControllerAndView<HomeController, VBox> homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void initialize() {
        backButton.setOnAction(actionEvent -> {
            back();
        });
        trashButton.setOnAction(actionEvent -> {
            trash();
        });
    }

    protected void updateScene() {
        super.updateScene();
        trashChoiceBox.getItems().addAll(getTrashNames());
        trashChoiceBox.getSelectionModel().selectFirst();

        binChoiceBox.getItems().addAll(getBinColors());
        binChoiceBox.getSelectionModel().selectFirst();
    }

    private void back() {
        homeController.getController().setConnectedUser(connectedUser);
        homeController.getController().show(getCurrentScene());
    }

    private List<String> getBinColors() {
        List<String> binColors = new ArrayList<String>();
        List<Bin> bins = binRepository.findAll();
        for (Bin bin : bins) {
            binColors.add(bin.getColor());
        }
        return binColors;
    }

    private List<String> getTrashNames() {
        List<String> trashNames = new ArrayList<String>();
        List<TrashConfig> trashConfigs = trashConfigRepository.findAll();
        for (TrashConfig trashConfig : trashConfigs) {
            trashNames.add(trashConfig.getName());
        }
        return trashNames;
    }

    private void trash() {
        // TODO
    }

}