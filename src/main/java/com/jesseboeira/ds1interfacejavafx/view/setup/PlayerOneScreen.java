package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.ds1interfacejavafx.util.ButtonUtils;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import com.jesseboeira.ds1jogodavelha.core.Jogador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        root.setStyle("-fx-background-color: black;"); // Fundo preto
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/playersBackground.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));  // Adiciona a imagem de fundo*/


        // Campo para o nome do jogador 1
        VBox nameFieldBox = new VBox();
        TextField nameField = new TextField();

        nameFieldBox.getChildren().add(nameField);
        nameFieldBox.setAlignment(Pos.CENTER);
        nameFieldBox.setMaxWidth(330);
        //nameFieldBox.setTranslateX(-35);
        nameFieldBox.setTranslateY(-50);
        nameField.setStyle("-fx-background-color: black;");
        //nameField.setPromptText("Digite o nome do Jogador 1");
        //nameField.setStyle("-fx-text-fill: black;");


        // Label do player
        VBox imgNameBox = new VBox();

        // Enter your name
        String imgNamePath = "/com.jesseboeira.ds1interfacejavafx.assets/enterYourName.png";
        Image image = new Image(getClass().getResource(imgNamePath).toExternalForm());
        ImageView imgName = new ImageView(image);

        imgNameBox.setAlignment(Pos.CENTER_LEFT);
        //Label playerOneLabel = new Label("Nome do Jogador 1:");
        //playerOneLabel.setStyle("-fx-background-color: black;");
        imgNameBox.getChildren().add(imgName);
        imgNameBox.setTranslateY(-90);
        imgNameBox.setTranslateX(35);


        //Escolha do time para o jogador 1
        VBox teamLabelBox = new VBox();
        teamLabelBox.setAlignment(Pos.CENTER);

        String imgTeamPath = "/com.jesseboeira.ds1interfacejavafx.assets/choseYourSide.png";
        Image imageTeam = new Image(getClass().getResource(imgTeamPath).toExternalForm());
        ImageView imgTeam = new ImageView(imageTeam);

        teamLabelBox.getChildren().add(imgTeam);


        //Label teamLabel = new Label("Escolha o time do Jogador 1:");

        // afg
        VBox teamGroupBox = new VBox();
        ToggleGroup teamGroup = new ToggleGroup();
        RadioButton xButton = new RadioButton("X");
        RadioButton oButton = new RadioButton("O");
        xButton.setToggleGroup(teamGroup);
        oButton.setToggleGroup(teamGroup);
        xButton.setSelected(true); // "X" selecionado por padrão

        teamGroupBox.getChildren().addAll(xButton, oButton);





        // Botão Avançar
        VBox nextButtonBox = new VBox();

        String imgNextPath = "/com.jesseboeira.ds1interfacejavafx.assets/next.png";
        Button nextButton = new Button();

        //ImageView buttonImage = new ImageView(new Image(imgNextPath));
        //nextButton.setGraphic(buttonImage); // Define a imagem como o botão
        nextButton.setGraphic(ButtonUtils.MainMenuButtons(imgNextPath)); // Define a imagem como o botão

        nextButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        //nextButtonBox.setStyle("-fx-background-color: white;");
        //nextButtonBox.setStyle("-fx-border-color: transparent;");
        //nextButtonBox.setStyle("-fx-background-color: transparent;");
        //nextButtonBox.setStyle("-fx-padding: -5");
        nextButtonBox.setMargin(nextButton, new Insets(0)); // Remove margens

        nextButtonBox.getChildren().add(nextButton);
        nextButtonBox.setTranslateY(-50);
        //nextButtonBox.setTranslateX(-10);




        nextButton.setOnAction(event -> {
            // Pega os valores dos campos
            String playerName = nameField.getText();
            if (!playerName.isEmpty()) {
                onNameEntered.accept(playerName);
            }

            char player1Team = ((RadioButton) teamGroup.getSelectedToggle()).getText().charAt(0);
            Jogador jogador1 = new Jogador(playerName, player1Team);
        });





        root.getChildren().addAll(nameFieldBox, imgNameBox, teamLabelBox, teamGroupBox, nextButtonBox);



        // Criar a cena
        Scene scene = new Scene(root, 400,400);
        stage.setTitle("Menu Principal");  // Título da janela

        stage.setScene(scene);
        stage.show();
    }
}
