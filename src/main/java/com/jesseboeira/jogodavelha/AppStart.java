package com.jesseboeira.jogodavelha;

import com.jesseboeira.jogodavelha.Screens.ScreenManager;
import com.jesseboeira.jogodavelha.Screens.SplashScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppStart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenManager screenManager = new ScreenManager(primaryStage);
        SplashScreen splashScreen = new SplashScreen(screenManager);
        splashScreen.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
