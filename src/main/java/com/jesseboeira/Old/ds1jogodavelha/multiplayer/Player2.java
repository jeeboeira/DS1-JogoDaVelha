package com.jesseboeira.Old.ds1jogodavelha.multiplayer;

import com.jesseboeira.Old.ds1jogodavelha.comm.UDPComm;
import com.jesseboeira.Old.ds1jogodavelha.core.Jogador;
import com.jesseboeira.Old.ds1jogodavelha.core.Jogo;
import com.jesseboeira.Old.ds1jogodavelha.core.PlayersHelper;

import java.util.Scanner;

public class Player2 {
    private static final int PORT = 1099;

    public void start() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o IP do host: ");
            String opponentHost = scan.nextLine();

            UDPComm comm = new UDPComm(opponentHost, PORT);

            // Cria o jogador local
            Jogador jogador2 = PlayersHelper.createPlayer1();

            // Envia informações do jogador local (time + nome)
            comm.sendMsg(jogador2.getTime() + jogador2.getNome());

            // Recebe informações do jogador remoto
            Jogador jogador1 = new Jogador("Host", jogador2.getTime() == 'X' ? 'O' : 'X');

            // Inicializa o jogo
            Jogo jogo = new Jogo(jogador1, jogador2);
            Jogo.startGame(jogo, comm, false);
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao host: " + e.getMessage());
        }
    }
}
