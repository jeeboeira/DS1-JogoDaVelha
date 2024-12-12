package com.jesseboeira.jogodavelha.Screens;

import com.jesseboeira.Old.ds1interfacejavafx.util.ButtonUtils;
import com.jesseboeira.jogodavelha.controller.MenuScreenController;
import com.jesseboeira.jogodavelha.controller.SplashScreenController;
import com.jesseboeira.jogodavelha.utils.ScreenUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuScreen {
    private final ScreenManager screenManager;

    public MenuScreen(ScreenManager screenManager) {this.screenManager = screenManager;}

    public void show() {

        // Cria a cena
        String backgroundPath = "/assets/images/menu.png";
        StackPane root = ScreenUtils.createScreenWithBackground(backgroundPath);

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

        screenManager.showScreen(root, "Menu Principal");

        // Configura eventos de interação
        MenuScreenController controller = new MenuScreenController(screenManager);
        localPlayButton.setOnAction(event -> controller.handleLocalPlay());
        onlinePlayButton.setOnAction(event -> controller.handleOnlinePlay());
        exitButton.setOnAction(event -> controller.handleExit());
        aboutButton.setOnAction(event -> controller.handleAbout());
    }
}
