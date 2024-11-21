package com.jesseboeira.ds1jogodavelha.core;

import com.jesseboeira.ds1jogodavelha.multiplayer.GameModeHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean continuePlaying = true;
        GameModeHelper.menuLoop(continuePlaying);

        scan.close();
    }
}
