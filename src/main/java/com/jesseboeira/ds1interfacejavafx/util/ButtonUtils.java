package com.jesseboeira.ds1interfacejavafx.util;

import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class ButtonUtils {
    public static Button MainMenuButtons(String imagePath) {
        Button button = new Button();

        Image image = new Image(ButtonUtils.class.getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);

        button.setStyle("-fx-background-color: black;");

        return button;
    }
}
