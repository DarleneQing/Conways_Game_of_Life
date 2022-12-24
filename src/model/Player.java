package model;

public abstract class Player {
    private final String name;
    private final String symbol;
    private final String color;
    private int numCells;
    private int numGens;

    public Player(String name, String symbol, String color){
       this.name = name;
       this.symbol = symbol;
       this.color = color;
       this.numCells = 4;
       this.numGens = 0;
    }

    public String getName(){
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getColor() {
        return this.color;
    }

    public int getNumCells(){
        return this.numCells;
    }

    public int getNumGens(){
        return this.numGens;
    }

}
