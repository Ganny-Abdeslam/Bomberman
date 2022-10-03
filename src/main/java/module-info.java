module main.bomberman {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.bomberman to javafx.fxml;
    exports main.bomberman;
}