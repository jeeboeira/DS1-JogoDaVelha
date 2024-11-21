package com.jesseboeira.ds1interfacejavafx;

import com.jesseboeira.ds1interfacejavafx.view.SplashScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {              // Classe principal do Jogo da Velha FX.

    @Override
    public void start(Stage primaryStage) {
        // Exibe a tela inicial (Splash Screen)
        com.jesseboeira.ds1interfacejavafx.view.SplashScreen splashScreen = new SplashScreen();
        splashScreen.show(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
