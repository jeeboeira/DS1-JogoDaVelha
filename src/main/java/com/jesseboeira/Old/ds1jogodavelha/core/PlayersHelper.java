package com.jesseboeira.Old.ds1jogodavelha.core;

import java.util.Scanner;

public class PlayersHelper {
    static Scanner scan = new Scanner(System.in);

    public static Jogador createPlayer1(){                // Coleta o nome e time do jogador 1

        System.out.print("Nome do jogador 1: ");
        String nome = scan.nextLine();
        System.out.print("Escolha o time (X/O): ");

        char time = escolheTime(scan.next().charAt(0));    //chama a ferramenta escolhe time, para receber apenas X ou O.

        return new Jogador(nome, time);
    }

    public static Jogador createPlayer2(Jogador j1) {

        System.out.print("Nome do jogador 2: ");
        String nome = scan.next();
        char time = (j1.time == 'X') ? 'O' : 'X';
        System.out.printf("Seu time é o: %s%n", time);

        return new Jogador(nome, time);
    }

    public static char escolheTime(char time) {
        switch (time) {
            case 'X':
            case 'x':
                return 'X';
            //break;
            case 'O':
            case 'o':
                return 'O';
            //break;
            default:
                System.out.println("Opção inválida, escolha X ou O");
                escolheTime(scan.next().charAt(0));
        }
        return 0;
    }


}

