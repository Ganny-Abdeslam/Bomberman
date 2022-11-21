package main.bomberman.logic.models;

public class Block implements  Source{
    private BlockType blockType;

    public Block(BlockType blockType){
        this.blockType = blockType;
    }

    public BlockType getBlockType() {
        return this.blockType;
    }

    @Override
    public String getImage() {
        if(blockType.equals(BlockType.BRICK)){
            return "Es destruible";
        }
        return "No es destruible";
    }

    @Override
    public String toString(){
        if(BlockType.BRICK == this.blockType){
            return "M";
        }
        return "L";
    }
}
