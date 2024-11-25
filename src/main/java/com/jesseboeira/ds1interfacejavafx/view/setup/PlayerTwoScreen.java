package com.jesseboeira.ds1interfacejavafx.view.setup;

import com.jesseboeira.ds1interfacejavafx.view.common.Screen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class PlayerTwoScreen implements Screen {

    private Consumer<String> onNameEntered;

    public PlayerTwoScreen(Consumer<String> onNameEntered){
        this.onNameEntered = onNameEntered;
    }

    @Override
    public void show(Stage stage) {
        HBox root = new HBox();
        // Configura a cena
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Menu Principal");
        stage.setScene(scene);
        stage.show();
    }
}
