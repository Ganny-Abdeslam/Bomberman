package main.bomberman.controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;

import static main.bomberman.controller.utilities.ImageFx.image;

/**
 * Clase para el splash del juego
 */
public class Splash {

    private Scene splash;
    final private Pane pane;

    public Splash() {

        this.pane = new Pane();
        this.pane.setStyle("-fx-background-color:#b6babd");

        this.splash = new Scene(this.pane, 720, 600);
    }

    public Pane getPane(){
        return this.pane;
    }

    /**
     * Llama la funcion de imagen para generarla y ponerla en el panel del splash
     */
    public void show() throws FileNotFoundException{
        this.pane.getChildren().add(image("./resource/Img/init.jpg", 0, 0, 750, 750));
    }

    public Scene getSplahScene(){
        return this.splash;
    }
}
