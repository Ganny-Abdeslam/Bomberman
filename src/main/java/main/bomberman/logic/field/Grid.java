package main.bomberman.logic.field;

import main.bomberman.logic.utilities.Coordinate;

public class Grid {

    private  final  int ROW = 10;
    private  final  int COLUMN = 20;
    private Box boxes[][] = new Box[ROW][COLUMN];

    public  Grid(){
        for (int row = 0; row < boxes.length; row++) {
            for (int column = 0; column < boxes[row].length; column++) {
                boxes[row][column] =  new Box(new Coordinate(row, column));
            }
        }
        this.start();
    }

    public Box[][] getBoxes(){
        return boxes;
    }

    public void start(){
        for(int row=0; row < boxes.length; row++){
            for (int column=0; column < boxes[row].length; column++){
                Box box = new Box(new Coordinate(row, column));

                //Indicación del tablero o Grilla para este caso
                box.setGrid(this);

                //Incluimos cada casilla "BOX" en nuestro arreglo de estas
                boxes[row][column] = box;

            }
        }
    }

    //Pruebas
    public String toString() {
        String result = "";
        for (int row = 0; row < boxes.length; row++) {
            String line = "";
            for (int column = 0; column < boxes[row].length; column++) {
                line += " " + boxes[row][column].toString() + " ";
            }
            result += line + "\n";
        }
        return result;
    }
}
