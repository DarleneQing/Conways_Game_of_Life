package model;

public class Player {
    private final String name;
    private final String symbol;
    private int numCells;
    private int numGens;

    public Player(String name, String symbol){
       this.name = name;
       this.symbol = symbol;
    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

}
