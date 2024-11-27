package com.jesseboeira.Old.ds1interfacejavafx.view.setup;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class PlayerConfirmationPopup {

    public static void show(String player1Name, String player1Symbol, String player2Name, String player2Symbol) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Configurações dos Jogadores");
        alert.setHeaderText("Jogadores Configurados");
        alert.setContentText(
                "Jogador 1: " + player1Name + " (" + player1Symbol + ")\n" +
                        "Jogador 2: " + player2Name + " (" + player2Symbol + ")"
        );

        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();
    }
}
