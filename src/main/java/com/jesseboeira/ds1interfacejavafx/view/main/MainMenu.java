package com.jesseboeira.ds1interfacejavafx.view.main;

import com.jesseboeira.ds1interfacejavafx.controller.MainMenuController;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainMenu implements Screen { // Menu principal com opções para iniciar o jogo

    private MainMenuController controller; // Controller do MainMenu

    public MainMenu(MainMenuController controller){
        this.controller = controller;
    }


    @Override
    public void show(Stage stage){

        // Layout da tela
        StackPane root = new StackPane(); // Cria o layout
        root.setStyle("-fx-background-color: black;"); // Fundo preto
        root.getChildren().add(imgSplashScreen());  // Adiciona a imagem de fundo


        // Botão no canto superior esquerdo
        StackPane about = new StackPane();
        HBox topBar = new HBox(100);

        Button aboutButton = new Button();

        topBar.getChildren().add(aboutButton);
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.setTranslateX(-6);
        topBar.setTranslateY(6);
        Image aboutpng = new Image(getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/about.png").toExternalForm());
        ImageView imageView = new ImageView(aboutpng);
        aboutButton.setGraphic(imageView);
        imageView.setFitWidth(70); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        aboutButton.setStyle("-fx-background-color: black;"); // Deixa o fundo preto

        //aboutButton.setPrefSize(10,10);
        about.getChildren().addAll(root, topBar);









        // Criar a cena
        Scene scene = new Scene(about, 400,400);
        stage.setTitle("Menu Principal");  // Título da janela
        stage.setScene(scene);
        stage.show();
    }



















    public ImageView imgSplashScreen() {
        // Carrega a imagem da splash screen
        Image splashImage = new Image(
                getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/menu.png").toExternalForm()
        );
        ImageView imageView = new ImageView(splashImage);
        imageView.setFitWidth(400); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        return imageView;
    }
}
/* stage.setResizable(false); // Boqueia aumento de tela

        StackPane root = new StackPane(); // Cria o layout
        root.setStyle("-fx-background-color: black;"); // Deixa o fundo preto


        //root.getChildren().addAll(imgSplashScreen()); // Adiciona a imagem de fundo


        // Cria a imagem de fundo
        //AnchorPane anchorPane = new AnchorPane();
        //root.setPrefSize(400, 400);
        //root.setStyle("-fx-background-color: black;");
        //stage.setResizable(false); // Impede o redimensionamento da janela

        // Adicionar imagem de fundo
        ImageView background = imgSplashScreen();
        //background.setFitWidth(400);
        //background.setFitHeight(400);
        // Definir as âncoras esquerda e direita do botão para centralizar no AnchorPane
        //AnchorPane.setLeftAnchor(background, 1.0); // Posição fixa à esquerda
        //AnchorPane.setRightAnchor(background, 1.0); // Posição fixa à direita
        //AnchorPane.setBottomAnchor(background, 1.0); // Posição fixa à esquerda
        //AnchorPane.setTopAnchor(background, 1.0); // Posição fixa à direita
        VBox stack = new VBox(400);
        // Botão no canto superior esquerdo
        Button aboutButton = new Button("Sobre");
        stack.setAlignment(Pos.CENTER);
        stack.getChildren().addAll(aboutButton);
        stack.setPrefWidth(40);
        //AnchorPane.setTopAnchor(aboutButton, 10.0); // 10px do topo
        //AnchorPane.setLeftAnchor(aboutButton, 10.0); // 10px da esquerda

        aboutButton.setOnAction(actionEvent -> {
            System.out.println("Jogo da Velha criado por Jessé\n21/11/24\nColocar mais coisas");
        });

        // HBox para os três botões inferiores
        HBox bottomButtons = new HBox(10); // Espaçamento entre botões
        //bottomButtons.setAlignment(javafx.geometry.Pos.CENTER); // Centralizar botões horizontalmente
        //StackPane.setAlignment(bottomButtons, javafx.geometry.Pos.BOTTOM_CENTER); // Alinhar na parte inferior
        //bottomButtons.setTranslateY(0); // Subir 10px do limite inferior
        bottomButtons.setAlignment(Pos.CENTER); // Centraliza os botões no HBox
        bottomButtons.setPrefWidth(40);

        // Criar os três botões inferiores
        Button localPlayButton = new Button("Jogar Local");
        Button onlinePlayButton = new Button("Jogar Online");
        Button exitButton = new Button("Sair");

        // Ações dos três botões inferiores
        localPlayButton.setOnAction(actionEvent -> {
            LocalGameSetup setupScreen = new LocalGameSetup();
            setupScreen.show(stage);
        });

        onlinePlayButton.setOnAction(event -> {
            OnlineGameSetup setupScreen = new OnlineGameSetup();
            setupScreen.show(stage);
        });

        exitButton.setOnAction(event -> System.exit(0));

        // Adicionar os botões ao HBox
        bottomButtons.getChildren().addAll(localPlayButton, onlinePlayButton, exitButton);

        // Posicionar o HBox na parte inferior
        AnchorPane.setBottomAnchor(bottomButtons, 10.0); // 10px acima do fundo
        AnchorPane.setLeftAnchor(bottomButtons, 0.0); // Alinhar à esquerda
        AnchorPane.setRightAnchor(bottomButtons, 0.0); // Alinhar à direita





        // Adicionar os três botões inferiores
        //bottomButtons.getChildren().addAll(localPlayButton, onlinePlayButton, exitButton);
        // Adicionar componentes ao AnchorPane


        // Contêiner estático
        Pane fixedPane = new Pane();
        fixedPane.setPrefSize(400, 400);


        // Botão no canto superior direito
        //Button aboutButton = new Button("Sobre");
        //aboutButton.setLayoutX(10); // Coordenada fixa X
        //aboutButton.setLayoutY(10); // Coordenada fixa Y
        //fixedPane.getChildren().add(aboutButton);
        //AnchorPane.setTopAnchor(aboutButton, 10.0); // 10px do topo
        //AnchorPane.setLeftAnchor(aboutButton, 10.0); // 10px da esquerda
/*
        // Ação do botão no canto superior direito
        aboutButton.setOnAction(actionEvent -> {
            System.out.println("Jogo da Velha criado por Jessé\n21/11/24\nColocar mais coisas");
        });
        StackPane.setAlignment(fixedPane, Pos.CENTER);
        // Adicionar os componentes ao StackPane
        //root.getChildren().addAll(imgSplashScreen(), fixedPane, bottomButtons);
        // Adicionar componentes ao AnchorPane
        root.getChildren().addAll(fixedPane, bottomButtons);*/
/*\|
// Adicionar todos os componentes ao AnchorPane
        root.getChildren().addAll(background, aboutButton, bottomButtons);


// Criar a cena
Scene scene = new Scene(root, 400,400);
        stage.setTitle("Menu Principal");  // Título da janela
        stage.setScene(scene);
        stage.show();*/