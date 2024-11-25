package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.controller.LocalGameSetupController;
import com.jesseboeira.ds1interfacejavafx.controller.PlayerOneController;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.function.Consumer;


public class PlayerOneScreen implements Screen {

    //private PlayerOneController controller;
    private Consumer<String> onNameEntered;

    /*public PlayerOneScreen(PlayerOneController controller) {
        this.controller = controller;
    }*/
    public PlayerOneScreen(Consumer<String> onNameEntered) {
        this.onNameEntered = onNameEntered;
    }

    @Override
    public void show(Stage stage) {
        stage.setResizable(false); // Boqueia aumento de tela

        // Layout principal
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");

        // Adiciona imagem de fundo
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/playersBackground.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));  // Adiciona a imagem de fundo*/

        // Configuração do campo de nome
        VBox nameFieldBox = createNameField();

        // Título "Enter Your Name"
        VBox imgNameBox = createEnterNameTitle();

        // Título "Choose Your Side"
        VBox teamLabelBox = createChooseSideTitle();

        // Seleção de time
        HBox teamGroupBox = createTeamSelection();

        // Botão Next
        VBox nextButtonBox = createNextButton(nameFieldBox, teamGroupBox);

        VBox clicaveis = new VBox();
        clicaveis.setAlignment(Pos.CENTER);
        clicaveis.getChildren().addAll(nextButtonBox, teamGroupBox, nameFieldBox,imgNameBox,teamLabelBox);

        // Adiciona todos os elementos ao layout
        root.getChildren().addAll(clicaveis);

        // Configura a cena
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createNameField() {
        VBox nameFieldBox = new VBox();
        TextField nameField = new TextField();
        nameFieldBox.getChildren().add(nameField);
        nameFieldBox.setAlignment(Pos.CENTER);
        nameFieldBox.setMaxWidth(330);
        nameFieldBox.setTranslateY(-100);
        nameField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        return nameFieldBox;
    }

    private VBox createEnterNameTitle() {
        VBox imgNameBox = new VBox();
        String imgNamePath = "/com.jesseboeira.ds1interfacejavafx.assets/enterYourName.png";
        ImageView imgName = new ImageView(new Image(getClass().getResource(imgNamePath).toExternalForm()));
        imgNameBox.getChildren().add(imgName);
        imgNameBox.setTranslateY(-170);
        imgNameBox.setAlignment(Pos.CENTER_LEFT);
        imgNameBox.setTranslateX(35);
        return imgNameBox;
    }

    private VBox createChooseSideTitle() {
        VBox teamLabelBox = new VBox();
        String imgTeamPath = "/com.jesseboeira.ds1interfacejavafx.assets/choseYourSide.png";
        ImageView imgTeam = new ImageView(new Image(getClass().getResource(imgTeamPath).toExternalForm()));
        teamLabelBox.getChildren().add(imgTeam);
        teamLabelBox.setAlignment(Pos.CENTER);
        teamLabelBox.setTranslateY(-80);
        return teamLabelBox;
    }

    private HBox createTeamSelection() {
        HBox teamGroupBox = new HBox(30);
        teamGroupBox.setAlignment(Pos.CENTER);
        teamGroupBox.setTranslateY(70);

        // Caminho imagens dos botões
        String imgX = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonX.png";
        String imgO = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonO.png";

        // Cria os botões de imagens
        Button xButton = ButtonUtils.ButtonImg(imgX);
        Button oButton = ButtonUtils.ButtonImg(imgO);

        // Adiciona os botões ao layout
        teamGroupBox.getChildren().addAll(xButton, oButton);


        // Adiciona lógica de seleção
        final char[] selectedTeam = {'\0'};
        selectedTeam[0] = 'X';
        xButton.setOnAction(event -> {
            selectedTeam[0] = 'X';
            System.out.println("clicou x");
            xButton.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 8;-fx-background-color: transparent;");
            oButton.setStyle("-fx-background-color: transparent;"); // Remove destaque do outro botão
        });

        oButton.setOnMouseClicked(event -> {
            selectedTeam[0] = 'O';
            System.out.println("clicou o");
            oButton.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 8;-fx-background-color: transparent;");
            xButton.setStyle("-fx-background-color: transparent;"); // Remove destaque do outro botão
        });
        teamGroupBox.setUserData(selectedTeam);
        return teamGroupBox;
    }

    private VBox createNextButton(VBox nameFieldBox, HBox teamGroupBox) {
        VBox nextButtonBox = new VBox();
        String imgNextPath = "/com.jesseboeira.ds1interfacejavafx.assets/next.png";
        Button nextButton = ButtonUtils.ButtonImg(imgNextPath);
        nextButtonBox.getChildren().add(nextButton);
        nextButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        nextButtonBox.setTranslateY(235);
        nextButtonBox.setTranslateX(-10);

        // Ação do botão Next
        nextButton.setOnAction(event -> {
            System.out.println("Botão next");
            // Obtém o nome do jogador
            TextField nameField = (TextField) nameFieldBox.getChildren().get(0);
            String playerName = nameField.getText();

            // Obtém o time selecionado
            char player1Team = ((char[]) teamGroupBox.getUserData())[0];



            // Verifica se o nome não está vazio
            if (!playerName.isEmpty()) {
                // Cria o jogador
                LocalGameSetupController.jogador1 = new Jogador(playerName, player1Team);
                onNameEntered.accept(playerName);


            }
        });

        return nextButtonBox;
    }
}
