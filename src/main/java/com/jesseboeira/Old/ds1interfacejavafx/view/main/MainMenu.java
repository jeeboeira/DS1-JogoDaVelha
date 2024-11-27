package com.jesseboeira.Old.ds1interfacejavafx.view.main;

import com.jesseboeira.Old.ds1interfacejavafx.controller.MainMenuController;
import com.jesseboeira.Old.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.Old.ds1interfacejavafx.util.ButtonUtils;
import com.jesseboeira.Old.ds1interfacejavafx.view.common.Screen;
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
        String backgroundPath = "/assets/images/menu.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));  // Adiciona a imagem de fundo


        // Botões Superiores
        HBox topBar = new HBox(230);

        // Caminho das imagens dos botões
        String imgAboutPath = "/assets/images/about.png";
        String imgExitPath = "/assets/images/exit.png";

        // Criar os botões superiores
        Button aboutButton = ButtonUtils.ButtonImg(imgAboutPath);
        Button exitButton = ButtonUtils.ButtonImg(imgExitPath);

        // Posiciona os botões
        topBar.getChildren().addAll(aboutButton, exitButton);
        topBar.setAlignment(Pos.TOP_CENTER);
        topBar.setTranslateY(3);


        // Botões Inferiores
        HBox bottomBar = new HBox(70);          // Espaçamento entre botões

        // Caminho das imagens dos botões
        String imgLocalPath = "/assets/images/localPlay.png";
        String imgOnlinePath = "/assets/images/onlinePlay.png";

        // Criar os três botões inferiores
        Button localPlayButton = ButtonUtils.ButtonImg(imgLocalPath);
        Button onlinePlayButton = ButtonUtils.ButtonImg(imgOnlinePath);

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