package com.jesseboeira.jogodavelha.controller;

import com.jesseboeira.jogodavelha.Screens.MenuScreen;
import com.jesseboeira.jogodavelha.Screens.ScreenManager;

public class MenuScreenController {
    private final ScreenManager screenManager;

    public MenuScreenController(ScreenManager screenManager) {this.screenManager};

    public void handleLocalPlay(){
        LocalGameSetup localGameSetup = new LocalGameSetup(screenManager);
    }
    public void handleOnlinePlay(){
        OnlineGameSetup onlineGameSetup = new OnlineGameSetup(screenManager);
    }
    public void handleExit(){System.exit(0);}

    public void handleAbout(){
        System.out.println("Jogo da Velha criado por Jessé\n21/11/24\nColocar mais coisas depois");}
    }
}