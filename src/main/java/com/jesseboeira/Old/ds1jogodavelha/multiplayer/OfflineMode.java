package com.jesseboeira.Old.ds1jogodavelha.multiplayer;

import com.jesseboeira.Old.ds1jogodavelha.core.Jogador;
import com.jesseboeira.Old.ds1jogodavelha.core.Jogo;
import com.jesseboeira.Old.ds1jogodavelha.core.PlayersHelper;

public class OfflineMode implements GameMode {
    @Override
    public void start() {
        Jogador jogador1 = PlayersHelper.createPlayer1();
        Jogador jogador2 = PlayersHelper.createPlayer2(jogador1);
        Jogo jogo = new Jogo(jogador1, jogador2);

        boolean j1Start = true;
        boolean continuar = true;
        while (continuar) {
            jogo.novoJogo();
            jogo.realizarPartida(jogador1, jogador2, j1Start);
            jogo.exibirResultado(jogador1, jogador2);

            j1Start = !j1Start;
            continuar = GameModeHelper.continuePlaying();
        }
    }
}
