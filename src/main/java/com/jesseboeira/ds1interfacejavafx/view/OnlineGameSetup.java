package com.jesseboeira.ds1interfacejavafx.view;

import com.jesseboeira.ds1jogodavelha.multiplayer.Host;
import com.jesseboeira.ds1jogodavelha.multiplayer.Player2;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OnlineGameSetup implements Screen {

    @Override
    public void show(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Escolha uma opção:");

        Button hostButton = new Button("Ser o Host");
        hostButton.setOnAction(event -> {
            // Inicia o modo host
            new Host().start();
        });

        Button connectButton = new Button("Conectar a um Jogador");
        connectButton.setOnAction(event -> {
            // Inicia o modo jogador 2
            new Player2().start();
        });

        root.getChildren().addAll(label, hostButton, connectButton);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Configuração do Jogo Online");
        stage.show();
    }
}