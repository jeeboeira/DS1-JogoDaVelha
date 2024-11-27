package com.jesseboeira.jogodavelha.controller;

import javafx.scene.input.KeyEvent;

public class SplashScreenController {
    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case ENTER -> System.out.println("Enter pressed! Starting the game...");
            case ESCAPE -> System.out.println("Escape pressed! Exiting...");
            default -> System.out.println("Key pressed: " + event.getCode());
        }
}
