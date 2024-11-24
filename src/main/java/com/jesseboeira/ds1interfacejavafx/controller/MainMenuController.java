package com.jesseboeira.ds1interfacejavafx.controller;

import com.jesseboeira.ds1interfacejavafx.view.main.MainMenu;
import com.jesseboeira.ds1interfacejavafx.view.setup.LocalGameSetup;
import com.jesseboeira.ds1interfacejavafx.view.setup.OnlineGameSetup;
import javafx.stage.Stage;

public class MainMenuController {

    public void handleLocalPlay(Stage stage) {
        /*LocalGameSetupController localGameSetupController = new LocalGameSetupController();
        LocalGameSetup setupScreen = new LocalGameSetup(localGameSetupController);
        setupScreen.show(stage);*/
        LocalGameSetupController localGameController = new LocalGameSetupController();
        localGameController.start(stage);
    }

    public void handleOnlinePlay(Stage stage) {
        OnlineGameSetup setupScreen = new OnlineGameSetup();
        setupScreen.show(stage);
    }

    public void handleExit() {System.exit(0);}

    public void handleAbout() {
        System.out.println("Jogo da Velha criado por Jessé\n21/11/24\nColocar mais coisas");}
}
