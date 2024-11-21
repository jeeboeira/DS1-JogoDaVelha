package com.jesseboeira.ds1interfacejavafx.view;

import com.jesseboeira.ds1interfacejavafx.controller.GameController;
import com.jesseboeira.ds1jogodavelha.core.Jogador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerSetupScreen implements Screen {

    private final String player1Name;
    private final String player1Team;

    public PlayerSetupScreen(String player1Name, String player1Team) {
        this.player1Name = player1Name;
        this.player1Team = player1Team;
    }

    @Override
    public void show(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Nome do jogador 2
        Label player2Label = new Label("Nome do jogador 2:");
        TextField player2Field = new TextField();
        player2Field.setPromptText("Digite o nome do Jogador 2");

        // Botão para iniciar o jogo
        Button startGameButton = new Button("Iniciar jogo");
        startGameButton.setOnAction(e -> {
            String player2Name = player2Field.getText().trim();
            String player2Team = player1Team.equals("X") ? "O" : "X";

            if (!player2Name.isEmpty()) {
                PlayerConfirmationPopup.show(player1Name, "X", player2Name, "O");

                // Criação dos jogadores e do controlador
                Jogador jogador1 = new Jogador(player1Name, player1Team.charAt(0));
                Jogador jogador2 = new Jogador(player2Name, player2Team.charAt(0));
                GameController gameController = new GameController(stage, jogador1, jogador2);

                // Inicia o jogo
                gameController.startGame();
            } else {
                player2Field.setPromptText("Nome Obrigatório!");
                player2Field.setStyle("-fx-border-color: red;");
            }
        });

        // Adiciona ao layout
        root.getChildren().addAll(player2Label, player2Field, startGameButton);

        // Cena
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Configuração do Jogador 2");
        stage.show();
    }
}
