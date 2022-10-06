package main.bomberman.logic.utilities;

import javafx.scene.Scene;
import main.bomberman.logic.models.Player;
import main.bomberman.logic.models.Unit;

public class Movements {
    public static void move(Scene scene, Unit player){
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W, UP -> displacement(player, -1, 0);
                case S, DOWN -> displacement(player, 1, 0);
                case A, LEFT -> displacement(player, 0, -1);
                case D, RIGHT -> displacement(player, 0, 1);
                case SPACE -> {
                    if (!player.getClass().equals(new Player().getClass())) {return;}
                    Player p = new Player(player.getBox(), player.getGrid());
                    p.placeBomb();
                }
            }
        });
    }

    public static void displacement(Unit unit, int row, int column){
        //Para no desbordarse
        if (!(unit.getCoordinate().getCol()+column >= 0 &&
            unit.getCoordinate().getCol()+column<=19 &&
            unit.getCoordinate().getRow()+row>=0 &&
            unit.getCoordinate().getRow()+row<=9)) {return;}

        //Asegurar que el campo a moverse no posea una unidad, bomba o bloque
        if(!(unit.getGrid().getBoxes()[unit.getCoordinate().getRow() + row]
            [unit.getCoordinate().getCol() + column].getUnit()==null &&

            unit.getGrid().getBoxes()[unit.getCoordinate().getRow() + row]
            [unit.getCoordinate().getCol() + column].getBomb()==null &&

            unit.getGrid().getBoxes()[unit.getCoordinate().getRow() + row]
            [unit.getCoordinate().getCol() + column].getBlock()==null)) {return;}

        //Movimiento si se cumplen las condiciones
        unit.getBox().setUnit(null);
        unit.getCoordinate().setRow(unit.getCoordinate().getRow() + row);
        unit.getCoordinate().setCol(unit.getCoordinate().getCol() + column);

        unit.setBox(unit.getGrid().getBoxes()
                [unit.getCoordinate().getRow()][unit.getCoordinate().getCol()]);

        unit.getBox().setUnit((Player) unit);
        System.out.println(unit.getGrid());
    }
}
