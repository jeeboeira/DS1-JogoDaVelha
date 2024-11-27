package com.jesseboeira.Old.ds1interfacejavafx.view.game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.function.BiConsumer;

public class GameBoardScreen {

    private final Button[][] buttons = new Button[3][3];
    private BiConsumer<Integer, Runnable> onMove;

    public void show(Stage stage, String player1Name, char player1Symbol, String player2Name, char player2Symbol,
                     BiConsumer<Integer, Runnable> onMove) {
        this.onMove = onMove;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(100, 100);
                buttons[i][j].setStyle("-fx-font-size: 24; -fx-text-fill: black;");

                int position = i * 3 + j;
                Button button = buttons[i][j];
                button.setOnAction(event -> {
                    onMove.accept(position, () -> {
                        //button.setText(player1Symbol);
                        button.setText(player1Symbol == 'X' ? "X" : "O");
                        button.setDisable(true);
                    });
                });

                grid.add(button, j, i);
            }
        }

        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Jogo da Velha");
        stage.show();
    }

    public void resetBoard() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setText("");
                button.setDisable(false);
            }
        }
    }

    public void showEndGame(String winnerName, Runnable onRestart) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fim de Jogo");
        alert.setHeaderText(winnerName != null ? "Vencedor: " + winnerName : "Empate!");
        alert.setContentText("Deseja jogar novamente?");
        alert.getButtonTypes().clear();

        Button restartButton = new Button("Jogar Novamente");
        restartButton.setOnAction(event -> {
            resetBoard();
            onRestart.run();
            alert.close();
        });

        Button exitButton = new Button("Sair");
        exitButton.setOnAction(event -> System.exit(0));

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(20);
        layout.add(restartButton, 0, 0);
        layout.add(exitButton, 1, 0);

        alert.getDialogPane().setContent(layout);
        alert.showAndWait();
    }
}
