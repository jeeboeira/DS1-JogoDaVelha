package com.jesseboeira.ds1interfacejavafx.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu implements Screen{ // Menu principal com opções para iniciar o jogo

    @Override
    public void show(Stage stage){

        VBox root = new VBox(20); // Layout Principal
        root.setAlignment(Pos.CENTER);

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
}
