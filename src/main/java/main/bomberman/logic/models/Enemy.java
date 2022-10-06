package main.bomberman.logic.models;

import javafx.concurrent.Task;
import main.bomberman.logic.field.Box;
import main.bomberman.logic.field.Grid;

import java.util.ArrayList;

public class Enemy extends Unit{

    private int countMovement;
    private Boolean life = true;

    public Enemy(){}

    public Enemy(Box box, Grid grid){
        super(box, grid);
        this.coordinate = box.getCoordinate();
        this.countMovement = 3;
    }

    public void setLife(Boolean life) {
        this.life = life;
    }

    public void movement(){
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                do {
                    Thread.sleep(1000);
                    System.out.println(""+ trajectory(0, -1));
                }while (life);

                return null;
            }
        };

        Thread thread = new Thread(task);
        //Asociar el proceso al proceso final, logrando así terminar todos los procesos
        thread.setDaemon(true);
        thread.start();
    }

    public void direction(){
        String[] sizes = new String[2];
        ArrayList<String[]> arraySizes = new ArrayList<>();
    }

    public int trajectory(int row, int column){

        if (this.coordinate.getRow()+row <= 19 && this.coordinate.getRow()+row >= 0 &&
            this.coordinate.getCol()+column <= 19 && this.coordinate.getCol()+column >= 0){return -1;}

        if(this.grid.getBoxes()[coordinate.getRow()+row]
            [coordinate.getCol()+column].getBlock() != null){
            return -1;
        }

        if(this.grid.getBoxes()[coordinate.getRow()+row]
                [coordinate.getCol()+column].getBomb() != null){
            return -5;
        }

        if(this.grid.getBoxes()[coordinate.getRow()+row]
                [coordinate.getCol()+column].getUnit() != null){
            return 10;
        }

        return 1;
    }
}
