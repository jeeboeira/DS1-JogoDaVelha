package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.controller.LocalGameSetupController;
import com.jesseboeira.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.ds1interfacejavafx.util.ButtonUtils;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import com.jesseboeira.ds1jogodavelha.core.Jogador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class PlayerTwoScreen implements Screen {
    private Consumer<String> onNameEntered;
    private char player1Team;

    public PlayerTwoScreen(Consumer<String> onNameEntered) {
        this.onNameEntered = onNameEntered;
    }

    @Override
    public void show(Stage stage) {
        this.player1Team = LocalGameSetupController.jogador1.getTime();
        stage.setResizable(false);

        // Layout principal
        StackPane root = new StackPane();

        // Adiciona imagem de fundo
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/playersBackground.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));

        // Configuração do campo de nome
        VBox nameFieldBox = createNameField();

        // Títulos e botões
        VBox imgNameBox = createEnterNameTitle();
        VBox teamLabelBox = createChooseSideTitle();
        HBox teamGroupBox = createTeamSelection();

        // Botão Next
        VBox nextButtonBox = createNextButton(nameFieldBox, teamGroupBox);

        // Agrupamento e posicionamento
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().addAll(imgNameBox, nameFieldBox, teamLabelBox, teamGroupBox, nextButtonBox);

        root.getChildren().add(contentBox);

        // Configura a cena
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Player Two Setup");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createNameField() {
        VBox nameFieldBox = new VBox();
        TextField nameField = new TextField();
        nameFieldBox.getChildren().add(nameField);
        nameFieldBox.setAlignment(Pos.CENTER);
        nameFieldBox.setMaxWidth(330);
        nameFieldBox.setTranslateY(22);
        nameField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        return nameFieldBox;
    }

    private VBox createEnterNameTitle() {
        VBox imgNameBox = new VBox();
        String imgNamePath = "/com.jesseboeira.ds1interfacejavafx.assets/enterYourName.png";
        ImageView imgName = new ImageView(new Image(getClass().getResource(imgNamePath).toExternalForm()));
        imgNameBox.getChildren().add(imgName);
        imgNameBox.setTranslateY(10);
        imgNameBox.setAlignment(Pos.CENTER_LEFT);
        imgNameBox.setTranslateX(35);
        return imgNameBox;
    }

    private VBox createChooseSideTitle() {
        VBox teamLabelBox = new VBox();
        String imgTeamPath = "/com.jesseboeira.ds1interfacejavafx.assets/yourSideIs.png";
        ImageView imgTeam = new ImageView(new Image(getClass().getResource(imgTeamPath).toExternalForm()));
        teamLabelBox.getChildren().add(imgTeam);
        teamLabelBox.setAlignment(Pos.CENTER);
        teamLabelBox.setTranslateY(30);
        return teamLabelBox;
    }

    private HBox createTeamSelection() {
        HBox teamGroupBox = new HBox(30);
        teamGroupBox.setAlignment(Pos.CENTER);
        teamGroupBox.setTranslateY(30);

        // Caminho imagens dos botões
        String imgX = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonX.png";
        String imgO = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonO.png";

        // Cria os botões
        Button xButton = ButtonUtils.ButtonImg(imgX);
        Button oButton = ButtonUtils.ButtonImg(imgO);


        // Configura os botões
        if (player1Team == 'X') {
            xButton.setDisable(true); // Desabilita a escolha já feita
            oButton.fire();
        } else {
            oButton.setDisable(true);
            xButton.fire();
        }

        xButton.setOnAction(event -> teamGroupBox.setUserData('X'));
        oButton.setOnAction(event -> teamGroupBox.setUserData('O'));

        // Adiciona os botões ao layout
        teamGroupBox.getChildren().addAll(xButton, oButton);

        return teamGroupBox;
    }

    private VBox createNextButton(VBox nameFieldBox, HBox teamGroupBox) {
        VBox nextButtonBox = new VBox();
        String imgNextPath = "/com.jesseboeira.ds1interfacejavafx.assets/next.png";
        Button nextButton = ButtonUtils.ButtonImg(imgNextPath);
        nextButtonBox.getChildren().add(nextButton);
        nextButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        nextButtonBox.setTranslateY(63);
        nextButtonBox.setTranslateX(-10);

        // Ação do botão Next
        nextButton.setOnAction(event -> {
            TextField nameField = (TextField) nameFieldBox.getChildren().get(0);
            String playerName = nameField.getText();
            // Define o time disponível para o jogador 2
            final char playerTeam = (player1Team == 'X') ? 'O' : 'X';
            //char playerTeam = ((char[]) teamGroupBox.getUserData())[0];

            if (!playerName.isEmpty() && playerTeam != '\0') {
                LocalGameSetupController.jogador2 = new Jogador(playerName, playerTeam);
                onNameEntered.accept(playerName);
            } else {
                System.out.println("Por favor, insira um nome e selecione um time.");
            }
        });

        return nextButtonBox;
    }
}
