package com.jesseboeira.jogodavelha.Screens;

import com.jesseboeira.jogodavelha.controller.SplashScreenController;
import com.jesseboeira.jogodavelha.utils.ScreenUtils;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyEvent;

public class SplashScreen {
    private final ScreenManager screenManager;

    public SplashScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void show() {

        // Cria a cena
        String backgroundPath = "/assets/images/splash.png";
        StackPane root = ScreenUtils.createScreenWithBackground(backgroundPath);

        screenManager.showScreen(root, "O Jogo da Velha"); // Configuração centralizada

        // Configura os eventos
        SplashScreenController controller = new SplashScreenController(screenManager);
        screenManager.getCurrentScene().setOnKeyPressed(event -> controller.handleSplashEvent());
        screenManager.getCurrentScene().setOnMouseClicked(event -> controller.handleSplashEvent());
    }
}
