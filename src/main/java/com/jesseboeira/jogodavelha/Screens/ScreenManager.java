package com.jesseboeira.jogodavelha.Screens;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {
    private final Stage stage;
    private Scene currentScene;

    public ScreenManager(Stage stage) {
        this.stage = stage;
    }

    public void showScreen(Parent root, String title) {
        currentScene = new Scene(root, 400, 400); // Dimensões padrão
        stage.setTitle(title);  // Título da janela
        stage.setScene(currentScene);
        stage.setResizable(false); // Bloqueia o redimensionamento
        stage.show();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Stage getStage() {
        return stage;
    }
}
