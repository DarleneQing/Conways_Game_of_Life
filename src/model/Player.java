package model;

public class Player {
    private final String name;
    private final String symbol;

    public Player(String name, String symbol){
       this.name = name;
       this.symbol = symbol;
       int numCells = 4;
       int numGens = 0;

    }

    public String getName(){
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

}
