package com.jesseboeira.ds1interfacejavafx.controller;

import com.jesseboeira.ds1interfacejavafx.view.setup.PlayerOneScreen;
import com.jesseboeira.ds1interfacejavafx.view.setup.PlayerTwoScreen;
import javafx.stage.Stage;

public class LocalGameSetupController {

    private String playerOneName;
    private String playerTwoName;

    public void start(Stage stage) {
        System.out.println("Iniciando Local Game");
        showPlayerOneScreen(stage);
    }

    private void showPlayerOneScreen(Stage stage) {
        PlayerOneScreen playerOneScreen = new PlayerOneScreen(name -> {
            this.playerOneName = name;
            showPlayerTwoScreen(stage);
        });
        playerOneScreen.show(stage);
    }

    private void showPlayerTwoScreen(Stage stage) {
        PlayerTwoScreen playerTwoScreen = new PlayerTwoScreen(name -> {
            this.playerTwoName = name;
            showBoard(stage);
        });
        playerTwoScreen.show(stage);
    }

    private void showBoard(Stage stage) {
        // Inicia o jogo
        //GameController controller = new GameController(stage, playerOneName, playerTwoName);
        //controller.startGame();
    }
}
