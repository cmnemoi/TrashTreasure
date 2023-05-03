package com.cytech.trashtreasure.application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.cytech.trashtreasure.controller.HomeController;
// import com.cytech.trashtreasure.controller.MainWindow;

import net.rgielen.fxweaver.core.FxWeaver;

@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;
    private final String applicationTitle;

    public PrimaryStageInitializer(FxWeaver fxWeaver, @Value("${app.title}") String applicationTitle) {
        this.fxWeaver = fxWeaver;
        this.applicationTitle = applicationTitle;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.stage;
        Scene scene = new Scene(fxWeaver.loadView(HomeController.class), 335, 600);
        stage.setScene(scene);
        stage.setTitle(applicationTitle);
        stage.show();
    }
}
