package com.jesseboeira.ds1interfacejavafx.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageManipulation {

    public static ImageView imgSplashScreen() {
        // Carrega a imagem da splash screen
        Image splashImage = new Image(
                ImageManipulation.class.getResource("/com.jesseboeira.ds1interfacejavafx.assets/splash.png").toExternalForm()
        );
        ImageView imageView = new ImageView(splashImage);
        imageView.setFitWidth(400); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        return imageView;
    }
}
