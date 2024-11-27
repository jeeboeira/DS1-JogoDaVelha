package com.jesseboeira.jogodavelha.utils;

import com.jesseboeira.Old.ds1interfacejavafx.util.BackgroundUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ScreenUtils {

    public static StackPane createScreenWithBackground(String backgroundPath) {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;"); // Fundo preto
        root.getChildren().add(backgrounds(backgroundPath)); // Adiciona a imagem
        return root;
    }

    public static ImageView backgrounds(String imagePath) {
        Image image = new Image(BackgroundUtils.class.getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);
        return imageView;
    }
}

