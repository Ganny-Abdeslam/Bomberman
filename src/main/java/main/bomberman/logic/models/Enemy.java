package main.bomberman.logic.models;

import javafx.concurrent.Task;
import main.bomberman.logic.field.Box;
import main.bomberman.logic.field.Grid;

public class Enemy extends Unit{

    private int countMovement;
    private Boolean life = true;

    public Enemy(){}

    public Enemy(Box box, Grid grid){
        super(box, grid);
        this.countMovement = 4;
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
                    System.out.println("Ella no te ama");
                }while (life);

                return null;
            }
        };

        Thread thread = new Thread(task);
        //Asociar el proceso al proceso final, logrando así terminar todos los procesos
        thread.setDaemon(true);
        thread.start();
    }
}
