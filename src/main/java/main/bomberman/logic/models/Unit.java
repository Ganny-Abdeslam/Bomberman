package main.bomberman.logic.models;

import main.bomberman.logic.field.Box;
import main.bomberman.logic.field.Grid;
import main.bomberman.logic.utilities.Coordinate;

public class Unit implements Source{

    protected Coordinate coordinate;

    protected Box box;

    protected Grid grid;

    public Unit(){

    }

    public Unit(Box box, Grid grid){
        this.box = box;
        this.grid = grid;
    }

    @Override
    public String getImage() {
        return null;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Box getBox() {
        return box;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public String toString(){
        return "D";
    }
}
