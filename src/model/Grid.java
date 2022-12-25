package model;

public class Grid {

    private String symbol;
    private String color;
    private GridStatus status;

    public enum GridStatus{
        ALIVE_1,
        ALIVE_2,
        DEAD
    }

    public Grid(String grid_symbol, String grid_color, GridStatus status){
        this.symbol = grid_symbol;
        this.color = grid_color;
        this.status = status;
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

    public void SetGridStatus(GridStatus status){
        this.status = status;
    }

    public void SetGridSymbol(String symbol){
        this.symbol = symbol;
    }

    public void SetGridColor(String color){
        this.color = color;
    }
}
