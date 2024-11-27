package com.jesseboeira.Old.ds1interfacejavafx.view.game;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class GameOverPopup {

    public static boolean show(String winnerName) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fim do Jogo");
        alert.setHeaderText(winnerName != null ? "Vencedor: " + winnerName : "Empate!");
        alert.setContentText("Deseja jogar novamente?");

        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

        return alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
    }
}
