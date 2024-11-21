package com.jesseboeira.ds1interfacejavafx.controller;

import com.jesseboeira.ds1interfacejavafx.view.GameBoardScreen;
import com.jesseboeira.ds1jogodavelha.core.Jogador;
import com.jesseboeira.ds1jogodavelha.core.Jogo;
import javafx.stage.Stage;

public class GameController {

    private final Jogo jogo;
    private final GameBoardScreen boardScreen;
    private boolean isPlayer1Turn = true; // Define quem joga primeiro

    public GameController(Stage stage, Jogador jogador1, Jogador jogador2) {
        this.jogo = new Jogo(jogador1, jogador2);

        this.boardScreen = new GameBoardScreen();
        this.boardScreen.show(stage, jogador1.getNome(), jogador1.getTime(), jogador2.getNome(), jogador2.getTime(), this::handleMove);
    }

    // Trata jogadas no tabuleiro
    private void handleMove(int position, Runnable updateUI) {
        Jogador currentPlayer = isPlayer1Turn ? jogo.getJ1() : jogo.getJ2();

        // Realiza a jogada na lógica
        if (jogo.fazerJogada(position, currentPlayer.getTime())) {
            updateUI.run(); // Atualiza a interface visualmente

            if (jogo.ehFimDoJogo()) {
                endGame();
            } else {
                isPlayer1Turn = !isPlayer1Turn; // Alterna entre os jogadores
            }
        }
    }

    // Finaliza o jogo e exibe resultado
    private void endGame() {
        Jogador vencedor = jogo.temVencedor(jogo.getJ1(), jogo.getJ2());
        String winnerName = vencedor != null ? vencedor.getNome() : "Empate";

        boardScreen.showEndGame(winnerName, () -> {
            jogo.novoJogo();
            isPlayer1Turn = true;
            boardScreen.resetBoard();
        });
    }

    public void startGame() {
        // Nenhuma ação adicional é necessária no momento
    }
}
