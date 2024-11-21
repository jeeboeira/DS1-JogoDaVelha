package com.jesseboeira.ds1interfacejavafx.view.common;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface Screen {
    void show(Stage stage);
    Scene getScene(Stage stage);
}

