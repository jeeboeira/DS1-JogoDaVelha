package com.jesseboeira.ds1interfacejavafx.util;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneFactory {
    private static final double DEFAULT_WIDTH = 400;
    private static final double DEFAULT_HEIGHT = 400;
    private static final String BACKGROUND_COLOR = "-fx-background-color: black"; // Cor de fundo

    // Método para criar uma cena com um StackPane
    public static Scene createScene(StackPane root) {
        root.setStyle(BACKGROUND_COLOR);
        return new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    // Método para criar uma cena com um StackPane e um Stage
    public static void setScene(Stage stage, StackPane root) {
        root.setStyle(BACKGROUND_COLOR);
        Scene scene = createScene(root);
        stage.setScene(scene);
        stage.show();
    }
}