package main.bomberman.logic.field;

import main.bomberman.logic.models.*;
import main.bomberman.logic.utilities.Coordinate;

public class Box {
    /**
     * Esta clase crea las cajas de la grilla
     * Esto para poner los barcos dentro de ellas
     */
    private Unit unit;
    private Block block;
    private Bomb bomb;
    private Coordinate coordinate;
    private Grid grid;
    private Explosion explosion;

    public Box(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Box(Coordinate coordinate, Unit unit){
        this.coordinate = coordinate;
        this.unit = unit;
    }

    public Box(Coordinate coordinate, Block block){
        this.coordinate = coordinate;
        this.block = block;
    }

    /**
     * GETTERS
     */
    public Unit getUnit() {
        return unit;
    }

    public Explosion getExplosion() {
        return explosion;
    }


    public Block getBlock() {
        return block;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * SETTERS
     */

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setExplosion(Explosion explosion) {
        this.explosion = explosion;
    }

    public void setUnit(Player unit) {
        this.unit = unit;
    }

    public void setUnit(Enemy enemy) {this.unit = enemy;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    //PRUEBA POR AHORA
    public String toString() {
        if (this.unit != null) {
            return this.unit.toString();
        }else if (this.bomb != null){
            return this.bomb.toString();
        }else if (this.explosion != null){
            return this.explosion.toString();
        }else if (this.block != null) {
            return this.block.toString();
        }
        return "*";
    }


}
