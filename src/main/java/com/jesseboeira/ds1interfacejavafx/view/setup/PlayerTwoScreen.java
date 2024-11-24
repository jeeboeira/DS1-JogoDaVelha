package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class PlayerTwoScreen implements Screen {

    private Consumer<String> onNameEntered;

    public PlayerTwoScreen(Consumer<String> onNameEntered){
        this.onNameEntered = onNameEntered;
    }

    @Override
    public void show(Stage stage) {
    }
}
