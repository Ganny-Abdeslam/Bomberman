package main.bomberman.logic.models;

public enum BlockType {
    BRICK(true),
    METAL(false);

    private boolean destroy;

    BlockType(boolean destroy){
        this.destroy = destroy;
    }

    public boolean getDestroy(){
        return this.destroy;
    }
}
