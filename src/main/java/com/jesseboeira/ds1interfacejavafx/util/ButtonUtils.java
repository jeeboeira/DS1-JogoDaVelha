package com.jesseboeira.ds1interfacejavafx.util;

import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class ButtonUtils {
    //Valor padrão
    public static Button ButtonImg(String imagePath) {
        Button button = new Button();

        Image image = new Image(ButtonUtils.class.getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent;"); // Remove a cor de fundo
        return button;
    }

    // Setar largura
    public static Button ButtonImg(String imagePath, int width) {
        Button button = new Button();

        Image image = new Image(ButtonUtils.class.getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }

    // Setar altura e largura
    public static Button ButtonImg(String imagePath, int width, int height) {
        Button button = new Button();

        Image image = new Image(ButtonUtils.class.getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView .setFitHeight(height);
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent;");
        return button;
    }

    // Construir RadioButton
    public static RadioButton RadioButtonImg(String imagePath) {
        RadioButton radioButton = new RadioButton();

        Image image = new Image(ButtonUtils.class.getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);
        radioButton.setGraphic(imageView);
        //radioButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-opacity: 0;");
        return radioButton;
    }
}
