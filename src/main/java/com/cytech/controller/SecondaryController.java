package com.cytech.controller;

import com.cytech.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("first");
    }

    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("third");
    }
}