package com.jesseboeira.ds1interfacejavafx.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplashScreen implements Screen { // Tela inicial do jogo

    @Override
    public void show(Stage stage) {
        StackPane root = new StackPane(); // Cria um layout simples para organizar os elementos

        // Carrega a imagem da splash screen
        Image splashImage = new Image(
                getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/splash.png").toExternalForm()
        );
        ImageView imageView = new ImageView(splashImage);
        imageView.setFitWidth(400); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem

        // Mensagem central
        //Label message = new Label("Pressione qualquer tecla para continuar...");
        //message.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");

        // Adiciona elementos ao layout
        root.getChildren().addAll(imageView);
        root.setStyle("-fx-background-color: black;"); // Define o fundo preto

        // Cria uma cena com o layout
        Scene scene = new Scene(root, 400, 400);

        // Configura ação para pressionar qualquer tecla
        scene.setOnKeyPressed((KeyEvent event) -> {
            MainMenu mainMenu = new MainMenu(); // Navega para o menu inicial
            mainMenu.show(stage);
        });
        // Configura ação para pressionar qualquer tecla
        scene.setOnMouseClicked((mouseEvent) -> {
            MainMenu mainMenu = new MainMenu(); // Navega para o menu inicial
            mainMenu.show(stage);
        });

        // Adiciona a cena ao palco
        stage.setScene(scene);
        stage.show();
    }
}
