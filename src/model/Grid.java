package model;

public class Grid {

    private String symbol;
    private String color;
    private GridStatus status;
    private GridStatus tempstatus;

    public enum GridStatus{
        ALIVE_1,
        ALIVE_2,
        DEAD
    }

    public Grid(String grid_symbol, String grid_color, GridStatus status){
        this.symbol = grid_symbol;
        this.color = grid_color;
        this.status = status;
        this.tempstatus = status;
    }

    public String getGridSymbol(){
        return this.symbol;
    }

    public String getGridColor(){
        return this.color;
    }

    public GridStatus getGridStatus(){
        return this.status;
    }

    public GridStatus getTempstatus(){
        return this.tempstatus;
    }

    public void SetTempstatus(GridStatus status){
        this.tempstatus = status;
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
