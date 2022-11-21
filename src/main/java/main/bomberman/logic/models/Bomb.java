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
            destruction();
            System.out.println(this.box.getGrid());
            Thread.sleep(3000);
            destruction();
            this.box.setBomb(null);
            System.out.println(this.box.getGrid());
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    private void destruction(){
        explosion(this.box.getCoordinate().getRow()+1, this.box.getCoordinate().getCol());
        explosion(this.box.getCoordinate().getRow()-1, this.box.getCoordinate().getCol());
        explosion(this.box.getCoordinate().getRow(), this.box.getCoordinate().getCol()+1);
        explosion(this.box.getCoordinate().getRow(), this.box.getCoordinate().getCol()-1);
    }

    private void explosion(int x, int y){
        if((this.box.getCoordinate().getRow()+x <= 9 && this.box.getCoordinate().getRow()+x >= 0 &&
                this.box.getCoordinate().getCol()+y <= 19 && this.box.getCoordinate().getCol()+y >= 0)
            ||  !(this.box.getGrid().getBoxes()[x][y].getBlock() != null)) {
            if (this.box.getGrid().getBoxes()[x][y].getExplosion() != null) {
                this.box.getGrid().getBoxes()[x][y].setExplosion(null);
            } else {
                this.box.getGrid().getBoxes()[x][y].setExplosion(new Explosion());
                if(!(this.box.getUnit() == null)){
                    this.box.getUnit().setLife(false);
                    System.out.println("100 points");
                }
            }
        }

    }

    @Override
    public String toString(){
        return "B";
    }
}
