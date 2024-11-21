package com.jesseboeira.ds1interfacejavafx.view.game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane {               // Representação gráfica do tabuleiro do jogo da velha.

    public BoardView() {                                // Centraliza o tabuleiro na tela
        setAlignment(Pos.CENTER);
        setHgap(10);                                    // Define espaçamento horizontal entre os botões
        setVgap(10);                                    // Define espaçamento vertical entre os botões

        // Adicionando os botões
        for (int row = 0; row < 3; row++) {             // Cria os botões para o tabuleiro 3x3
            for (int col = 0; col < 3; col++) {
                Button cell = new Button();
                cell.setPrefSize(100, 100);      // Define o tamanho de cada botão
                cell.setStyle("-fx-font-size: 24;");    // Estiliza tamanho e fonte do texto do botão

                cell.setOnAction(event -> {  // Adiciona ação ao botão
                    cell.setText("X");
                });

                add(cell, col, row);                    // Adiciona o botão ao GridPane na posição correspondente
            }
        }
    }
}
