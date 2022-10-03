package main.bomberman.logic.models;

import javafx.concurrent.Task;
import main.bomberman.logic.field.Box;

public class Bomb extends Task{
    private Box box;

    public Bomb(Box box){
        this.box = box;
    }

    public Box getBox() {
        return this.box;
    }

    @Override
    protected Object call() throws Exception {
        try{
            Thread.sleep(5000);
            this.box.setBomb(null);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String toString(){
        return "B";
    }
}
