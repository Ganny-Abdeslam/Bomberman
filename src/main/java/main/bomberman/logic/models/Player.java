package main.bomberman.logic.models;

import javafx.scene.input.KeyEvent;
import main.bomberman.logic.field.Box;
import main.bomberman.logic.field.Grid;

public class Player extends Unit {

    public Player(){}
    public Player(Box box, Grid grid){
        super(box, grid);
        this.coordinate = box.getCoordinate();
    }

    public void placeBomb(){
        Bomb bomb = new Bomb(this.box);
        this.box.setBomb(bomb);
        (new Thread(bomb)).start();
    }

    @Override
    public String toString(){
        return "?";
    }
}
