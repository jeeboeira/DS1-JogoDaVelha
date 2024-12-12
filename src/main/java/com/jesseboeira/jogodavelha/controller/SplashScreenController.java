package com.jesseboeira.jogodavelha.controller;

import com.jesseboeira.jogodavelha.Screens.MenuScreen;
import com.jesseboeira.jogodavelha.Screens.ScreenManager;
import javafx.scene.input.KeyEvent;

public class SplashScreenController {
    private final ScreenManager screenManager;

    public SplashScreenController(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void handleSplashEvent() {
        // Lógica para mover para a próxima tela (Menu)
        MenuScreen menuScreen = new MenuScreen(screenManager);
        menuScreen.show();
    }
}
