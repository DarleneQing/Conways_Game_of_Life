package model;

public class PlayeruseColor extends Player{
    private final String color;

    public PlayeruseColor(String name, String color) {
        super(name);
        this.color = color;
        int numCells = 4;
        int numGens = 0;
    }

    public String getColor() {
        return this.color;
    }
}
