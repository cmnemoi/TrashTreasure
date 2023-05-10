package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.dao.TrashDao;
import com.cytech.trashtreasure.service.TrashService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("DepositsView.fxml")
public class DepositsController extends AbstractController {

    @FXML
    public Button backButton;
    @FXML
    public TableView<TrashDao> depositsTableView;

    @Autowired
    private TrashService trashService;

    private final FxControllerAndView<HomeController, VBox> homeController;

    public DepositsController(FxControllerAndView<HomeController, VBox> homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void initialize() {
        backButton.setOnAction(actionEvent -> {
            back();
        });
    }

    protected void updateScene() {
        super.updateScene();

        depositsTableView.getItems().clear();
        depositsTableView.getColumns().clear();
        createColumns();

        depositsTableView.getItems().addAll(
            trashService.getUserDeposits(connectedUser).stream().map(TrashDao::new).toArray(TrashDao[]::new)
        );
    }

    private void createColumns() {
        TableColumn<TrashDao, String> depositDateTableColumn = new TableColumn<>("Date de dépôt");
        depositDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("depositDate"));
        TableColumn<TrashDao, String> trashNameTableColumn = new TableColumn<>("Déchet");
        trashNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<TrashDao, String> trashWeightTableColumn = new TableColumn<>("Quantité");
        trashWeightTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<TrashDao, String> binColorTableColumn = new TableColumn<>("Poubelle");
        binColorTableColumn.setCellValueFactory(new PropertyValueFactory<>("bin"));
        TableColumn<TrashDao, String> earnedPointsTableColumn = new TableColumn<>("Points gagnés");
        earnedPointsTableColumn.setCellValueFactory(new PropertyValueFactory<>("earnedPoints"));

        depositsTableView.getColumns().addAll(
            depositDateTableColumn,
            trashNameTableColumn,
            trashWeightTableColumn,
            binColorTableColumn,
            earnedPointsTableColumn
        );
    }

    private void back() {
        homeController.getController().setConnectedUser(connectedUser);
        homeController.getController().show(getCurrentScene());
    }
}
