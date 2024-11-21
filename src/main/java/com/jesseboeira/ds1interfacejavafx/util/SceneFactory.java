package dsiinterfaceemjavafx.util;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneFactory {
    private static final double DEFAULT_WIDTH = 400;
    private static final double DEFAULT_HEIGHT = 400;
    private static final String BACKGROUND_COLOR = "-fx-background-color: black"; // Cor de fundo

    // Método para criar uma cena com um StackPane
    public static Scene createScene(StackPane root) {
        root.setStyle(BACKGROUND_COLOR);
        return new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    // Método para criar uma cena com um StackPane e um Stage
    public static void setScene(Stage stage, StackPane root) {
        root.setStyle(BACKGROUND_COLOR);
        Scene scene = createScene(root);
        stage.setScene(scene);
        stage.show();
    }

    private ImageView imgSplashScreen() {
        // Carrega a imagem da splash screen
        Image splashImage = new Image(
                getClass().getResource("/com.jesseboeira.ds1interfacejavafx.assets/splash.png").toExternalForm()
        );
        ImageView imageView = new ImageView(splashImage);
        imageView.setFitWidth(DEFAULT_WIDTH); // Ajusta a largura da imagem
        imageView.setPreserveRatio(true); // Mantém a proporção original da imagem
        return imageView;
    }
}