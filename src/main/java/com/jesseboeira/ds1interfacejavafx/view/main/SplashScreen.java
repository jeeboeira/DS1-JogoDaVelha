package com.jesseboeira.ds1interfacejavafx.view.main;

import com.jesseboeira.ds1interfacejavafx.controller.SplashScreenController;
import com.jesseboeira.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplashScreen implements Screen { // Tela inicial do jogo

    private SplashScreenController controller; // Controller da SplashScreen

    public SplashScreen(SplashScreenController controller) {
        this.controller = controller;
    }


    @Override
    public void show(Stage stage) {
        stage.setResizable(false); // Boqueia aumento de tela

        // Layout da tela inicial
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;"); // Fundo preto
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/splash.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath)); // Adiciona a imagem de fundo

        // Cria a cena
        Scene scene = new Scene(root, 400, 400);

        // Configura eventos de interação
        scene.setOnKeyPressed(event -> controller.handleAnyEvent(stage));
        scene.setOnMouseClicked(event -> controller.handleAnyEvent(stage));

        // Adiciona a cena ao palco
        stage.setScene(scene);
        stage.show();
    }
}