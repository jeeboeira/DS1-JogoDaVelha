package com.jesseboeira.Old.ds1jogodavelha.multiplayer;

public class GameModeFactory {

    public static GameMode getGameMode(int option) {
        return switch (option) {
            case 1 -> new OfflineMode();
            case 2 -> new OnlineMode();
            case 3 -> new RemoteServerMode();
            default -> throw new IllegalArgumentException("Opção inválida");
        };
    }
}
