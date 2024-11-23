package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.controller.PlayerOneSetupScreenController;
import com.jesseboeira.ds1interfacejavafx.util.BackgroundUtils;
import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerOneSetup implements Screen {
    private PlayerOneSetupScreenController controller;

    public PlayerOneSetup(PlayerOneSetupScreenController controller){this.controller = controller;}

    @Override
    public void show(Stage stage) {
        stage.setResizable(false); // Boqueia aumento de tela

        // Layout da tela
        StackPane root = new StackPane(); // Cria o layout
        root.setStyle("-fx-background-color: black;"); // Fundo preto
        String backgroundPath = "/com.jesseboeira.ds1interfacejavafx.assets/playersBackground.png";
        root.getChildren().add(BackgroundUtils.backgrounds(backgroundPath));  // Adiciona a imagem de fundo





        // Criar a cena
        Scene scene = new Scene(root, 400,400);
        stage.setTitle("Menu Principal");  // Título da janela

        stage.setScene(scene);
        stage.show();
    }
}
