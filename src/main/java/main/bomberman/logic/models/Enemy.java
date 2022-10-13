package main.bomberman.logic.models;

import javafx.concurrent.Task;
import main.bomberman.logic.field.Box;
import main.bomberman.logic.field.Grid;

import static main.bomberman.logic.utilities.Movements.move;
import static main.bomberman.logic.utilities.RandomFunction.generateRandomNumbers;

public class Enemy extends Unit{

    private String listMovements;
    private int valueTrajectory = 0;
    private Enemy enemy = this;

    private Boolean life = true;

    public Enemy(){}

    public Enemy(Box box, Grid grid){
        super(box, grid);
        this.coordinate = box.getCoordinate();
    }

    public void setLife(Boolean life) {
        this.life = life;
    }

    public void movement(){
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                do {
                    destination(0, "", 0, 0, 0);
                    for (char mov: listMovements.toCharArray()) {
                        move(enemy, mov);
                        Thread.sleep(5000);
                        System.out.println(box.getGrid());
                    }
                    valueTrajectory = 0;
                }while (life);

                return null;
            }
        };

        Thread thread = new Thread(task);
        //Asociar el proceso al proceso final, logrando así terminar todos los procesos
        thread.setDaemon(true);
        thread.start();
    }

    //Arreglar el total, puesto que se trabaja internamente como un puntero y por ende da más valor del que debería
    public void destination(int accumulated, String listMovements, int total, int row, int column){
        char[] list = {'U', 'D', 'L', 'R'};
        int i = 0;

        do {
            if(accumulated!=4){
                switch (list[i]){
                    case 'U':
                        if(trajectory(-1, 0)>0) {
                            total += trajectory(row, column);
                            destination(accumulated += 1, listMovements + list[i], total, row - 1, column);
                            total -= trajectory(row, column);
                        }else {accumulated+=1;}
                    break;
                    case 'D':
                        if(trajectory(1, 0)>0) {
                            total += trajectory(row, column);
                            destination(accumulated += 1, listMovements + list[i], total, row + 1, column);
                            total -= trajectory(row, column);
                        }else {accumulated+=1;}
                        break;
                    case 'L':
                        if(trajectory(0, -1)>0) {
                            total += trajectory(row, column);
                            destination(accumulated += 1, listMovements + list[i], total, row, column - 1);
                            total -= trajectory(row, column);
                        }else {accumulated+=1;}
                        break;
                    case 'R':
                        if(trajectory(0, 1)>0) {
                            total += trajectory(row, column);
                            destination(accumulated += 1, listMovements + list[i], total, row, column + 1);
                            total -= trajectory(row, column);
                        }else {accumulated+=1;}
                        break;
                }
                valueMax(listMovements, total);
                accumulated-=1;
            }else {
                valueMax(listMovements, total);
                //System.out.println("La trayectoria es: "+listMovements+"-----Y su total es: "+total);
                return;
            }
            valueMax(listMovements, total);
            i+=1;
        }while (i<4);
    }

    public void valueMax(String listMovements, int valueTrajectory){
        if(this.valueTrajectory < valueTrajectory){
            this.valueTrajectory = valueTrajectory;
            this.listMovements = listMovements;
        }else if(this.valueTrajectory == valueTrajectory){
            if(generateRandomNumbers(0, 21)<1){
                this.listMovements = listMovements;
            }
        }
    }
    public int trajectory(int row, int column){

        if (!(this.coordinate.getRow()+row <= 9 && this.coordinate.getRow()+row >= 0 &&
            this.coordinate.getCol()+column <= 19 && this.coordinate.getCol()+column >= 0)){return -10;}

        if(this.grid.getBoxes()[coordinate.getRow()+row]
            [coordinate.getCol()+column].getBlock() != null){
            return -1;
        }

        if(this.grid.getBoxes()[coordinate.getRow()+row]
                [coordinate.getCol()+column].getBomb() != null){
            return -5;
        }

        if(this.grid.getBoxes()[coordinate.getRow()+row]
                [coordinate.getCol()+column].getUnit() != null && !(row==0 && column==0)){
            if(this.grid.getBoxes()[coordinate.getRow()+row]
                    [coordinate.getCol()+column].getUnit().equals(this)){
                return -10;
            }
            return 10;
        }

        return 1;
    }

    @Override
    public String toString(){return "E";}
}
