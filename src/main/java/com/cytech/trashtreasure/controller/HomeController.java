package com.cytech.trashtreasure.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;

import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import com.gluonhq.charm.glisten.control.Icon;

@Component
@FxmlView("HomeView.fxml")
public class HomeController {

    @FXML
    private BottomNavigation favoriteButton; // Value injected by FXMLLoader

    @FXML
    private BottomNavigationButton bookmarkButton; // Value injected by FXMLLoader

    @FXML
    private Icon icon; // Value injected by FXMLLoader


    public HomeController() {
        
    }

    @FXML
    public void initialize() {
        
    }
}
