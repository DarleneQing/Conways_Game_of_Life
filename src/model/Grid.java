package model;

import exceptions.InvalidSize;

public class Grid {

    private String symbol;
    private GridStatus status;
    private int[][] position;


    enum GridStatus{
        ALIVE,
        DEAD
    }

    public Grid(String grid_symbol, GridStatus status, int[][] position){
        this.symbol = grid_symbol;
        this.status = status;
        this.position = position;
    }

    public String getGridSymbol(){
        return symbol;
    }

    public GridStatus getGridStatus(){
        return status;
    }

    public int[][] getGridPosition(){
        return position;
    }


}
