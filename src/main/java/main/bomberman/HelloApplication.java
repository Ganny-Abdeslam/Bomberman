package main.bomberman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.bomberman.logic.field.Grid;
import main.bomberman.logic.models.*;
import main.bomberman.logic.utilities.Movements;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        pruebas(scene);
    }

    public void pruebas(Scene scene){
        Grid grid = new Grid();
        grid.start();

        Unit player = new Player(grid.getBoxes()[1][1], grid);
        Unit enemy = new Enemy(grid.getBoxes()[5][10], grid);
        Unit enemy01 = new Enemy(grid.getBoxes()[7][12], grid);

        for (int i=0; i<20; i++){
            grid.getBoxes()[0][i].setBlock(new Block(BlockType.METAL));
            grid.getBoxes()[9][i].setBlock(new Block(BlockType.METAL));
        }
        for (int i=0; i<10; i++){
            grid.getBoxes()[i][0].setBlock(new Block(BlockType.METAL));
            grid.getBoxes()[i][19].setBlock(new Block(BlockType.METAL));
        }

        ((Enemy) enemy).movement();
        ((Enemy) enemy01).movement();

        grid.getBoxes()[1][1].setUnit((Player) player);
        grid.getBoxes()[5][10].setUnit((Enemy) enemy);
        grid.getBoxes()[7][12].setUnit((Enemy) enemy01);
        System.out.println(grid);

        //Mover el personaje
        Movements.move(scene, player);
    }

    public static void main(String[] args) {
        launch();
    }
}