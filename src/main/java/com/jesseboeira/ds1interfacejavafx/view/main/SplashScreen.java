package com.jesseboeira.ds1interfacejavafx.view.main;

import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplashScreen implements Screen { // Tela inicial do jogo

    @Override
    public void show(Stage stage) {
        StackPane root = new StackPane(); // Cria o layout

        root.getChildren().addAll(imgSplashScreen()); // Adiciona a imagem de fundo
        root.setStyle("-fx-background-color: black;");

        // Cria uma cena com o layout
        Scene scene = new Scene(root, 400, 400);

        // Configura ação para pressionar qualquer tecla
        scene.setOnKeyPressed((KeyEvent event) -> {
            MainMenu mainMenu = new MainMenu(); // Navega para o menu inicial
            mainMenu.show(stage);
        });
        // Configura ação para pressionar qualquer tecla
        scene.setOnMouseClicked((mouseEvent) -> {
            MainMenu mainMenu = new MainMenu(); // Navega para o menu inicial
            mainMenu.show(stage);
        });

        // Adiciona a cena ao palco
        stage.setScene(scene);
        stage.show();
    }

    public ImageView imgSplashScreen() {
        // Carrega a imagem da splash screen
        Image splashImage = new Image(
                getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/splash.png").toExternalForm()
        );
        ImageView imageView = new ImageView(splashImage);
        imageView.setFitWidth(400); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        return imageView;
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