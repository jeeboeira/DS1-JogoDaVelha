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


        //Banner escolha do time para o jogador 1
        VBox teamLabelBox = new VBox();
        teamLabelBox.setAlignment(Pos.CENTER);

        String imgTeamPath = "/com.jesseboeira.ds1interfacejavafx.assets/choseYourSide.png";
        Image imageTeam = new Image(getClass().getResource(imgTeamPath).toExternalForm());
        ImageView imgTeam = new ImageView(imageTeam);

        teamLabelBox.getChildren().add(imgTeam);


        //Botões dos timers
        HBox teamGroupBox = new HBox();
        ToggleGroup teamGroup = new ToggleGroup();

        // Caminho imagens dos botões
        String imgX = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonX.png";
        String imgO = "/com.jesseboeira.ds1interfacejavafx.assets/ButtonO.png";

        // Criando os botões com imagens
        RadioButton xButton = new RadioButton();
        RadioButton oButton = new RadioButton();

        xButton.setToggleGroup(teamGroup);
        oButton.setToggleGroup(teamGroup);
        xButton.setSelected(true); // "X" selecionado por padrão


        // Criando o circulo de destaque
        Circle highlightCircle = new Circle(40); // Raio do círculo
        highlightCircle.setStroke(Color.YELLOW);
        highlightCircle.setFill(Color.TRANSPARENT);
        highlightCircle.setVisible(true); // Invisível inicialmente

        // StackPane para agrupar cada botão com seu círculo
        StackPane xButtonPane = createCustomRadioButton(imgX, xButton);
        StackPane oButtonPane = createCustomRadioButton(imgO, oButton);

        // Adiciona os botões empilhados no VBox
        teamGroupBox.getChildren().addAll(xButtonPane, oButtonPane);





        Circle xHighlightCircle = new Circle(100, Color.YELLOW);
        xHighlightCircle.setStroke(Color.YELLOW);
        xHighlightCircle.setStrokeWidth(3);
        xHighlightCircle.setVisible(true); // Invisível inicialmente

        Circle oHighlightCircle = new Circle(150, Color.YELLOW);
        oHighlightCircle.setStroke(Color.YELLOW);
        oHighlightCircle.setStrokeWidth(3);
        oHighlightCircle.setVisible(true); // Invisível inicialmente

        // Adiciona o botão e o círculo no StackPane
        xButtonPane.getChildren().addAll(xHighlightCircle, xButton);
        oButtonPane.getChildren().addAll(oHighlightCircle, oButton);

        // Listener para alternar a visibilidade do círculo
        teamGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == xButton) {
                xHighlightCircle.setVisible(true);
                oHighlightCircle.setVisible(false);
            } else if (newToggle == oButton) {
                xHighlightCircle.setVisible(false);
                oHighlightCircle.setVisible(true);
            }
        });



        xButton.setOnAction(event -> {
            xButton.setStyle("-fx-border-color: yellow; -fx-border-width: 3; -fx-border-radius: 50%;");
            oButton.setStyle(""); // Remove o estilo do outro botão
        });

        oButton.setOnAction(event -> {
            oButton.setStyle("-fx-border-color: yellow; -fx-border-width: 3; -fx-border-radius: 50%;");
            xButton.setStyle(""); // Remove o estilo do outro botão
        });



        // Botão Avançar
        VBox nextButtonBox = new VBox();
        String imgNextPath = "/com.jesseboeira.ds1interfacejavafx.assets/next.png";
        Button nextButton = ButtonUtils.ButtonImg(imgNextPath);

        nextButtonBox.setAlignment(Pos.BOTTOM_RIGHT);

        nextButtonBox.getChildren().add(nextButton);
        nextButtonBox.setTranslateY(-10);
        nextButtonBox.setTranslateX(-10);




        nextButton.setOnAction(event -> {
            // Pega os valores dos campos
            String playerName = nameField.getText();
            if (!playerName.isEmpty()) {
                onNameEntered.accept(playerName);
            }

            char player1Team = ((RadioButton) teamGroup.getSelectedToggle()).getText().charAt(0);
            Jogador jogador1 = new Jogador(playerName, player1Team);
        });





        root.getChildren().addAll(nameFieldBox,
                                  imgNameBox,
                                  teamLabelBox,
                                  teamGroupBox,
                                  nextButtonBox
        );



        // Criar a cena
        Scene scene = new Scene(root, 400,400);
        stage.setTitle("Menu Principal");  // Título da janela

        stage.setScene(scene);
        stage.show();
    }

    // Método para criar um botão de imagem customizado
    private StackPane createCustomRadioButton(String imgPath, RadioButton radioButton) {
        ImageView buttonImage = new ImageView(new Image(getClass().getResource(imgPath).toExternalForm()));
        buttonImage.setFitWidth(80); // Defina o tamanho da imagem
        buttonImage.setFitHeight(80);

        // Torna o RadioButton invisível
        radioButton.setStyle("-fx-opacity: 0;");

        // Agrupando imagem e botão invisível
        StackPane buttonPane = new StackPane();
        buttonPane.getChildren().addAll(buttonImage, radioButton);
        buttonPane.setOnMouseClicked(event -> radioButton.fire()); // Permite que o clique ative o botão

        // Listener para mudar a aparência da imagem quando selecionado
        radioButton.selectedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                buttonImage.setOpacity(1.0); // Muda a opacidade da imagem quando selecionada
            } else {
                buttonImage.setOpacity(0.5); // Muda a opacidade da imagem quando não selecionada
            }
        });

        return buttonPane;
    }
}
