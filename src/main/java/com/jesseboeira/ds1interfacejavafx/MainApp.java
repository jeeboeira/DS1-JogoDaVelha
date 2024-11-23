package com.jesseboeira.ds1interfacejavafx;

import com.jesseboeira.ds1interfacejavafx.controller.SplashScreenController;
import com.jesseboeira.ds1interfacejavafx.view.main.SplashScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Exibe a tela inicial (Splash Screen)
        SplashScreenController splashScreenController = new SplashScreenController();
        SplashScreen splashScreen = new SplashScreen(splashScreenController);
        splashScreen.show(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
