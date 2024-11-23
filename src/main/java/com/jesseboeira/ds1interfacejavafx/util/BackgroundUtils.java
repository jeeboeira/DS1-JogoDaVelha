package com.jesseboeira.ds1interfacejavafx.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundUtils {

    public static ImageView backgrounds(String imagePath) {
        // Carrega a imagem
        Image image = new Image(
                BackgroundUtils.class.getResource(imagePath).toExternalForm()
        );
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400); // Ajusta a largura da imagem
        //imageView.setFitHeight(400);
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        return imageView;
    }
}
