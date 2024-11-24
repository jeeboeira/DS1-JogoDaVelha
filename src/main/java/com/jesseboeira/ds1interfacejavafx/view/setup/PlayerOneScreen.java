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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class PlayerOneScreen implements Screen {

    private Consumer<String> onNameEntered;

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
        VBox nextButtonBox = createNextButton(stage, nameFieldBox, teamGroupBox);

        // Adiciona todos os elementos ao layout
        root.getChildren().addAll(
                nameFieldBox,
                imgNameBox,
                teamLabelBox,
                teamGroupBox,
                nextButtonBox
        );

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
        nameFieldBox.setTranslateY(-50);
        nameField.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        return nameFieldBox;
    }

    private VBox createEnterNameTitle() {
        VBox imgNameBox = new VBox();
        String imgNamePath = "/com.jesseboeira.ds1interfacejavafx.assets/enterYourName.png";
        ImageView imgName = new ImageView(new Image(getClass().getResource(imgNamePath).toExternalForm()));
        imgNameBox.getChildren().add(imgName);
        imgNameBox.setTranslateY(-90);
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
        return teamLabelBox;
    }

    private HBox createTeamSelection() {
        HBox teamGroupBox = new HBox(30);
        teamGroupBox.setAlignment(Pos.CENTER);
        teamGroupBox.setTranslateY(70);

        // Grupo de seleção
        ToggleGroup teamGroup = new ToggleGroup();

        // Caminho imagens dos botões
        String imgX = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonX.png";
        String imgO = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonO.png";

        // Cria os botões de imagens
        RadioButton xButton = ButtonUtils.RadioButtonImg(imgX);
        RadioButton oButton = ButtonUtils.RadioButtonImg(imgO);

        xButton.setStyle("-fx-background-color: transparent; -fx-opacity: 0;"); // Oculta o RadioButton


        // Configura o grupo de seleção
        xButton.setToggleGroup(teamGroup);
        oButton.setToggleGroup(teamGroup);
        xButton.setSelected(true); // "X" selecionado por padrão

        // Adiciona os botões ao layout
        teamGroupBox.getChildren().addAll(xButton, oButton);

        return teamGroupBox;
    }

    private VBox createNextButton(Stage stage, VBox nameFieldBox, HBox teamGroupBox) {
        VBox nextButtonBox = new VBox();
        String imgNextPath = "/com.jesseboeira.ds1interfacejavafx.assets/next.png";
        Button nextButton = ButtonUtils.ButtonImg(imgNextPath);
        nextButtonBox.getChildren().add(nextButton);
        nextButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        nextButtonBox.setTranslateY(-10);
        nextButtonBox.setTranslateX(-10);

        // Ação do botão Next
        nextButton.setOnAction(event -> {
            // Obtém o nome do jogador
            TextField nameField = (TextField) nameFieldBox.getChildren().get(0);
            String playerName = nameField.getText();

            // Verifica se o nome não está vazio
            if (!playerName.isEmpty()) {
                onNameEntered.accept(playerName);

                // Obtém o time selecionado
                ToggleGroup teamGroup = ((RadioButton) teamGroupBox.getChildren().get(0)).getToggleGroup();
                RadioButton selectedTeam = (RadioButton) teamGroup.getSelectedToggle();
                char player1Team = selectedTeam.getText().charAt(0);

                // Cria o jogador
                Jogador jogador1 = new Jogador(playerName, player1Team);
            }
        });

        return nextButtonBox;
    }
}
