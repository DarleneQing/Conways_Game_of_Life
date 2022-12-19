package model;

public class Grid {

    private final boolean colorornot;
    private final String symbol;
    private final String color;
    private final GridStatus status;
    private final int[][] position;

    enum GridStatus{
        ALIVE_1,
        ALIVE_2,
        DEAD
    }

    public Grid(boolean colorornot, String grid_symbol, String grid_color, GridStatus status, int[][] position){
        this.colorornot = colorornot;
        this.symbol = grid_symbol;
        this.color = grid_color;
        this.status = status;
        this.position = position;
    }

    public String getGridSymbol(){
        return symbol;
    }

    public String getGridColor(){
        return color;
    }

    public GridStatus getGridStatus(){
        return status;
    }

    public int[][] getGridPosition(){
        return position;
    }
}
