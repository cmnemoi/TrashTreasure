package com.cytech.trashtreasure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.service.TrashService;
import com.cytech.trashtreasure.service.UserService;
import com.cytech.trashtreasure.service.VoucherService;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import com.cytech.trashtreasure.entity.Trash;
import java.util.HashMap;
import java.util.List;


@Component
@FxmlView("StatsView.fxml")
public class StatsController extends AbstractController {

    @FXML
    public Button backButton;
    @FXML
    public Label usersAmountLabel;
    @FXML
    public Label totalTrashAmountLabel;
    @FXML
    public Label correctlyClassifiedTrashAmountLabel;
    @FXML
    public Label vouchersAmountLabel;
    @FXML
    public BarChart<String, Integer> trashTypeRepartitionBarChart;

    @Autowired
    private TrashService trashService;
    @Autowired
    private UserService userService;
    @Autowired
    private VoucherService voucherService;

    private final FxControllerAndView<HomeController, VBox> homeController;

    public StatsController(FxControllerAndView<HomeController, VBox> homeController) {
        this.homeController = homeController;
    }

    public void initialize() {
        backButton.setOnAction(actionEvent -> back());
    }

    protected void updateScene() {
        super.updateScene();
        updateKpis();
        updateTrashTypeRepartitionBarChart();
        updateTrashBinRepartitionBarChart();
    }

    private void back() {
        homeController.getController().setConnectedUser(connectedUser);
        homeController.getController().show(getCurrentScene());
    }

    private void updateKpis() {
        usersAmountLabel.setText(String.valueOf(userService.getNumberOfUsers()));
        totalTrashAmountLabel.setText(String.valueOf(trashService.getNumberOfTrash()));
        correctlyClassifiedTrashAmountLabel.setText(
            String.valueOf(trashService.getCorrectlyClassifiedTrashAmount().getKey()) + " (" +
            String.valueOf(trashService.getCorrectlyClassifiedTrashAmount().getValue()) + "% des déchets)"
        );
        vouchersAmountLabel.setText(String.valueOf(voucherService.getNumberOfClaimedVouchers()));
    }

    private void updateTrashTypeRepartitionBarChart() {
        trashTypeRepartitionBarChart.getData().clear();

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Type de déchet");
        for (String trashType : trashService.getAllTrashTypes()) {
            series.getData().add(new XYChart.Data<>(trashType, trashService.getNumberOfTrashByType(trashType)));
        }

        trashTypeRepartitionBarChart.getData().add(series);
    }

    @FXML
public BarChart<String, Integer> trashBinRepartitionBarChart;

private void updateTrashBinRepartitionBarChart() {
    trashBinRepartitionBarChart.getData().clear();

    List<Trash> allTrash = trashService.getAllTrash();  

    HashMap<String, HashMap<String, Integer>> binTrashCount = new HashMap<>();
    for (String binColor : trashService.getAllBinNames()) {
        binTrashCount.put(binColor, new HashMap<>());
        for (String trashType : trashService.getAllTrashTypes()) {
            binTrashCount.get(binColor).put(trashType, 0);
        }
    }

    for (Trash trash : allTrash) {
        String binColor = trash.getBin().getColor();
        String trashType = trash.getType();
        if (trashService.isTrashInItsRightBin(trash)) {
            binTrashCount.get(binColor).put(trashType, binTrashCount.get(binColor).get(trashType) + 1);
        }
        
    }

    for (String binColor : binTrashCount.keySet()) {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName(binColor);
        for (String trashType : binTrashCount.get(binColor).keySet()) {
            if (binTrashCount.get(binColor).get(trashType) > 0) {
                series.getData().add(new XYChart.Data<>(trashType, binTrashCount.get(binColor).get(trashType)));
            }
        }
        trashBinRepartitionBarChart.getData().add(series);
    }
}

    
}
