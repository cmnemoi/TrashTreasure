package com.cytech.trashtreasure;

import javafx.application.Application;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cytech.trashtreasure.application.SpringBootJavaFxApplication;

@SpringBootApplication
public class TrashTreasureApp {

    public static void main(String[] args) {
        Application.launch(SpringBootJavaFxApplication.class, args);
    }

}
