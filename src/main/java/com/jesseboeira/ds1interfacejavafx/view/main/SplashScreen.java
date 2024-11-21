package com.jesseboeira.ds1interfacejavafx.view.main;

import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import com.jesseboeira.ds1interfacejavafx.util.SceneFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplashScreen implements Screen { // Tela inicial do jogo

    @Override
    public void show(Stage stage) {
        StackPane root = createRoot(); // Cria o layout

        Scene scene = getScene(stage, root); // Cria a cena

        // Adiciona a cena ao palco
        stage.setScene(scene);
        stage.show();
    }

    private StackPane createRoot() {
        StackPane root = new StackPane();
        root.getChildren().addAll(imgSplashScreen()); // Adiciona a imagem de fundo
        return root;
    }

    private Scene getScene(Stage stage, StackPane root) {
        Scene scene = new Scene(root);

        // Configura ações para pressionar qualquer tecla ou clicar com o mouse
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnMouseClicked(mouseEvent -> handleMouseClick(stage));

        return scene;
    }

    private void handleKeyPress(KeyEvent event) {
        navigateToMainMenu();
    }

    private void handleMouseClick(Stage stage) {
        navigateToMainMenu();
    }

    private void navigateToMainMenu() {
        MainMenu mainMenu = new MainMenu(); // Navega para o menu inicial
        mainMenu.show(stage);
    }



    /*
    private void playSplashMusic() {
        Media splashMusic = new Media(
                getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/splash_music.mp3").toExternalForm()
        );
        MediaPlayer mediaPlayer = new MediaPlayer(splashMusic);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Faz a música repetir indefinidamente
        mediaPlayer.play(); // Inicia a música
    }
    */
}