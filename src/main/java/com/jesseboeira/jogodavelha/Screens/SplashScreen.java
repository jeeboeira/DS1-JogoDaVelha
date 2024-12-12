package com.jesseboeira.jogodavelha.Screens;

import com.jesseboeira.jogodavelha.utils.ScreenUtils;
import javafx.scene.layout.StackPane;

public class SplashScreen {
    private final ScreenManager screenManager;

    public SplashScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void show() {

        // Cria a cena
        String backgroundPath = "/assets/images/splash.png";
        StackPane root = ScreenUtils.createScreenWithBackground(backgroundPath);
        screenManager.showScreen(root); // Configuração centralizada

        // Configura os eventos
        screenManager.getCurrentScene().setOnKeyPressed(this::handleKeyPress);
        screenManager.getCurrentScene().setOnMouseClicked(this::handleKeyPress);
    }
}
