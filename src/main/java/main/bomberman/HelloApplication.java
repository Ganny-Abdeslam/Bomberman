package main.bomberman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.bomberman.controller.Splash;

import java.io.FileNotFoundException;
import java.io.IOException;

import static main.bomberman.controller.utilities.Window.extras;
import static main.bomberman.controller.utilities.Window.topBar;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Splash splash = new Splash();
        splash.show();

        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(splash.getSplahScene());

        Timeline timeline = new Timeline(500);
        KeyFrame key = new KeyFrame(Duration.millis(500));
        timeline.getKeyFrames().add(key);
        timeline.setOnFinished(event ->{
                    try {
                        primary(primaryStage, "hello-view.fxml");
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        timeline.play();
        primaryStage.show();
    }

    public static void primary(Stage primaryStage, String msj) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource(msj));
        Group groupObject = new Group();
        HBox hBox = topBar();

        groupObject.getChildren().add(root);
        groupObject.getChildren().add(hBox);

        root.setStyle("-fx-background-image: url('https://i.ytimg.com/vi/FwvJHOjGazc/hqdefault.jpg');" +
                "-fx-background-position: center center;");

        Scene scene = new Scene(groupObject, 720, 600);
        extras(primaryStage, hBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}