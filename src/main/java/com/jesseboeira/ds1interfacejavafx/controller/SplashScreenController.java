package com.jesseboeira.ds1interfacejavafx.controller;

import com.jesseboeira.ds1interfacejavafx.view.main.MainMenu;
import javafx.stage.Stage;

public class SplashScreenController {

    public void handleAnyEvent(Stage stage) {
        navigateToMainMenu(stage);
    }

    private void navigateToMainMenu(Stage stage) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.show(stage);
    }
}
