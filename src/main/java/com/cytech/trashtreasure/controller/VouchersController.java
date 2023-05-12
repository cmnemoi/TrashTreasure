package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.dao.VoucherDao;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("VouchersView.fxml")
public class VouchersController extends AbstractController {

    @FXML
    public Button backButton;
    @FXML
    public TableView<VoucherDao> vouchersTableView;

    private final FxControllerAndView<HomeController, VBox> homeController;

    public VouchersController(FxControllerAndView<HomeController, VBox> homeController) {
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

        vouchersTableView.getItems().clear();
        vouchersTableView.getColumns().clear();
        createColumns();

        vouchersTableView.getItems().addAll(
            connectedUser.getVouchers().stream().map(VoucherDao::new).toArray(VoucherDao[]::new)
        );
    }

    private void createColumns() {
        TableColumn<VoucherDao, String> discountTableColumn = new TableColumn<>("Réduction");
        discountTableColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));

        TableColumn<VoucherDao, String> shopTableColumn = new TableColumn<>("Enseigne");
        shopTableColumn.setCellValueFactory(new PropertyValueFactory<>("shop"));

        TableColumn<VoucherDao, String> pointsCostTableColumn = new TableColumn<>("Points dépensés");
        pointsCostTableColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        vouchersTableView.getColumns().addAll(
            discountTableColumn,
            shopTableColumn,
            pointsCostTableColumn
        );
    }

    private void back() {
        homeController.getController().setConnectedUser(connectedUser);
        homeController.getController().show(getCurrentScene());
    }
}
