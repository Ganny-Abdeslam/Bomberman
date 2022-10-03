package main.bomberman.logic.utilities;

public class Coordinate {
    private int row = 0;
    private int col = 0;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int compareTo(Coordinate coordinate) {
        if (this.getRow() == coordinate.getRow() && this.getCol() == coordinate.getCol()) {
            return 0;
        }
        return -1;
    }
}
