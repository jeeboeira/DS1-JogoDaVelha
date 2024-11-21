package com.jesseboeira.ds1interfacejavafx.view.main;

import com.jesseboeira.ds1interfacejavafx.view.setup.OnlineGameSetup;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import com.jesseboeira.ds1interfacejavafx.view.setup.LocalGameSetup;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu implements Screen { // Menu principal com opções para iniciar o jogo

    @Override
    public void show(Stage stage){

        VBox root = new VBox(20); // Layout Principal
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(imgSplashScreen()); // Adiciona a imagem de fundo
        ////////////////////
        // Botões do menu //
        ////////////////////
        Button localPlayButton = new Button("Jogar Local");
        Button onlinePlayButton = new Button("Jogar Online");
        Button aboutButton = new Button("Sobre");

        //////////////////////
        // Ações dos botões //
        //////////////////////
        localPlayButton.setOnAction(actionEvent -> {
            LocalGameSetup setupScreen = new LocalGameSetup();
            setupScreen.show(stage);
        });

        onlinePlayButton.setOnAction(event -> {
            OnlineGameSetup setupScreen = new OnlineGameSetup();
            setupScreen.show(stage);
        });

        aboutButton.setOnAction(actionEvent -> {
            System.out.println("Jogo da Velha criado por Jessé\nColocar mais coisas");
        });

        //////////////////////////////////
        // Adiciona os botões ao layout //
        //////////////////////////////////
        root.getChildren().addAll(localPlayButton,
                                  onlinePlayButton,
                                  aboutButton
        );

        ///////////////////
        // Cria uma Cena //
        ///////////////////
        Scene scene = new Scene(root, 400,400);
        stage.setScene(scene);
        stage.show();
    }

    public ImageView imgSplashScreen() {
        // Carrega a imagem da splash screen
        Image splashImage = new Image(
                getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/splash.png").toExternalForm()
        );
        ImageView imageView = new ImageView(splashImage);
        imageView.setFitWidth(400); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        return imageView;
    }
}
