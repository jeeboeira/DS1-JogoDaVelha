package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.controller.PlayerOneSetupScreenController;
import com.jesseboeira.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import com.jesseboeira.ds1jogodavelha.core.Jogador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class PlayerOneScreen implements Screen{

    private Consumer<String> onNameEntered;

    public PlayerOneScreen(Consumer<String> onNameEntered){
        this.onNameEntered = onNameEntered;
    }

    @Override
    public void show(Stage stage) {
        stage.setResizable(false); // Boqueia aumento de tela

        // Layout da tela
        StackPane root = new StackPane(); // Cria o layout
        //root.setStyle("-fx-background-color: black;"); // Fundo preto
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/playersBackground.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));  // Adiciona a imagem de fundo*/


        // Campo para o nome do jogador 1
        VBox nameFieldBox = new VBox();
        TextField nameField = new TextField();

        nameFieldBox.getChildren().addAll(nameField);
        nameFieldBox.setAlignment(Pos.CENTER);
        //nameFieldBox.setTranslateY(-9);
        nameField.setStyle("-fx-background-color: black;");
        nameField.setStyle("-fx-text-fill: black;");


        // Label do player
        Label playerOneLabel = new Label("Nome do Jogador 1:");
        nameField.setPromptText("Digite o nome do Jogador 1");

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
            String playerName = nameField.getText();
            if (!playerName.isEmpty()) {
                onNameEntered.accept(playerName);
            }

            char player1Team = ((RadioButton) teamGroup.getSelectedToggle()).getText().charAt(0);
            Jogador jogador1 = new Jogador(playerName, player1Team);
        });




        root.getChildren().addAll(nameFieldBox, xButton, oButton, nextButton);



        // Criar a cena
        Scene scene = new Scene(root, 400,400);
        scene.getStylesheets().add(getClass().getResource("/com/jesseboeira/ds1interfacejavafx/view/setup/Style.css").toExternalForm());
        stage.setTitle("Menu Principal");  // Título da janela

        stage.setScene(scene);
        stage.show();
    }
}
