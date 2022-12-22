package model;

public class PlayeruseSymbol extends Player{
    private final String symbol;

    public PlayeruseSymbol(String name, String symbol) {
        super(name);
        this.symbol = symbol;
        int numcells = 4;
        int numGens = 0;
    }

    public String getSymbol() {
        return this.symbol;
    }

}
