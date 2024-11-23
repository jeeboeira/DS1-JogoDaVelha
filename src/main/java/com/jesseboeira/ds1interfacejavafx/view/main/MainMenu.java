package com.jesseboeira.ds1interfacejavafx.view.main;

import com.jesseboeira.ds1interfacejavafx.controller.MainMenuController;
import com.jesseboeira.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.ds1interfacejavafx.util.ButtonUtils;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainMenu implements Screen { // Menu principal com opções para iniciar o jogo

    private MainMenuController controller; // Controller do MainMenu

    public MainMenu(MainMenuController controller){this.controller = controller;}


    @Override
    public void show(Stage stage){
        stage.setResizable(false); // Boqueia aumento de tela

        // Layout da tela
        StackPane root = new StackPane(); // Cria o layout
        root.setStyle("-fx-background-color: black;"); // Fundo preto
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/menu.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));  // Adiciona a imagem de fundo


        // Botões Superiores
        HBox topBar = new HBox(230);

        // Caminho das imagens dos botões
        String imgAboutPath = "/com.jesseboeira.ds1interfacejavafx.assets/about.png";
        String imgExitPath = "/com.jesseboeira.ds1interfacejavafx.assets/exit.png";

        // Criar os botões superiores
        Button aboutButton = ButtonUtils.MainMenuButtons(imgAboutPath);
        Button exitButton = ButtonUtils.MainMenuButtons(imgExitPath);

        // Posiciona os botões
        topBar.getChildren().addAll(aboutButton, exitButton);
        topBar.setAlignment(Pos.TOP_CENTER);
        topBar.setTranslateY(3);


        // Botões Inferiores
        HBox bottomBar = new HBox(70);          // Espaçamento entre botões

        // Caminho das imagens dos botões
        String imgLocalPath = "/com.jesseboeira.ds1interfacejavafx.assets/localPlay.png";
        String imgOnlinePath = "/com.jesseboeira.ds1interfacejavafx.assets/onlinePlay.png";

        // Criar os três botões inferiores
        Button localPlayButton = ButtonUtils.MainMenuButtons(imgLocalPath);
        Button onlinePlayButton = ButtonUtils.MainMenuButtons(imgOnlinePath);

        bottomBar.getChildren().addAll(localPlayButton, onlinePlayButton);
        bottomBar.setAlignment(Pos.BOTTOM_CENTER);
        bottomBar.setTranslateY(-4);


        // Criar um VBox para organizar os botões
        VBox vbox = new VBox(333);
        vbox.getChildren().addAll(topBar, bottomBar);
        vbox.setAlignment(Pos.CENTER); // Centraliza os botões no VBox

        // Adiciona o VBox ao root
        root.getChildren().add(vbox);

        // Criar a cena
        Scene scene = new Scene(root, 400,400);
        stage.setTitle("Menu Principal");  // Título da janela


        // Configura eventos de interação
        localPlayButton.setOnAction(event -> controller.handleLocalPlay(stage));
        onlinePlayButton.setOnAction(event -> controller.handleOnlinePlay(stage));
        exitButton.setOnAction(event -> controller.handleExit());
        aboutButton.setOnAction(event -> controller.handleAbout());

        stage.setScene(scene);
        stage.show();
    }
}