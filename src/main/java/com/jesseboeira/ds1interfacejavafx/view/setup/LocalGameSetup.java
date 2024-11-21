package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.controller.GameController;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import com.jesseboeira.ds1jogodavelha.core.Jogador;
import com.jesseboeira.ds1jogodavelha.core.PlayersHelper;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LocalGameSetup implements Screen { // Trocar para players

    @Override
    public void show(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        // Campo para o nome do jogador 1
        Label player1Label = new Label("Nome do jogador 1:");
        TextField player1Field = new TextField();
        player1Field.setPromptText("Digite o nome do Jogador 1");

        //Escolha do time para o jogador 1
        Label teamLabel = new Label("Escolha o time do Jogador 1:");
        ToggleGroup teamGroup = new ToggleGroup();
        RadioButton xButton = new RadioButton("X");
        RadioButton oButton = new RadioButton("O");
        xButton.setToggleGroup(teamGroup);
        oButton.setToggleGroup(teamGroup);
        xButton.setSelected(true); // "X" selecionado por padrão

        // Botão Avançar
        Button nextButton = new Button("Avançar");
        nextButton.setOnAction(event -> {
            // Pega os valores dos campos
            String player1Name = player1Field.getText().trim();
            if (player1Name.isEmpty()) {
                player1Field.setPromptText("Nome Obrigatório!");
                player1Field.setStyle("-fx-border-color: red;"); // Colocar isso em uma classe separada
                return;
            }

            char player1Team = ((RadioButton) teamGroup.getSelectedToggle()).getText().charAt(0);
            Jogador jogador1 = new Jogador(player1Name, player1Team);

            // Configuração do jogador 2
            Jogador jogador2 = PlayersHelper.createPlayer2(jogador1);

            // Inicia o jogo
            GameController controller = new GameController(stage, jogador1, jogador2);
            controller.startGame();
        });

        // Adiciona ao layout
        root.getChildren().addAll(player1Label, player1Field, teamLabel, xButton, oButton, nextButton);

        // Cena
        Scene scene = new Scene(root, 400,400);
        stage.setScene(scene);
        stage.setTitle("Configuração de jogo Local");
        stage.show();
    }
}
