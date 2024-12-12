package com.jesseboeira.jogodavelha.controller;

import com.jesseboeira.jogodavelha.Screens.ScreenManager;
import javafx.scene.input.KeyEvent;

public class SplashScreenController {
    private final ScreenManager screenManager;

    public SplashScreenController(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    private void handleSplashEvent() {
        switch (event.getCode()) {
            case ENTER -> System.out.println("Enter pressed! Starting the game...");
            case ESCAPE -> System.out.println("Escape pressed! Exiting...");
            default -> System.out.println("Key pressed: " + event.getCode());
        }
    }
}
