package com.jesseboeira.Old.ds1interfacejavafx;

import com.jesseboeira.Old.ds1interfacejavafx.controller.MainMenuController;
import com.jesseboeira.Old.ds1interfacejavafx.view.main.MainMenu;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainMenuTest extends Application {              // Classe principal do Jogo da Velha FX.

    @Override
    public void start(Stage primaryStage) {

        // Exibe a tela inicial (Splash Screen)
        MainMenuController mainMenuController = new MainMenuController();
        MainMenu menu = new MainMenu(mainMenuController);
        menu.show(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
