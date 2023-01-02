package main.board;

import main.grid.Grid;

import java.util.Objects;

public class BoarduseColor implements Board{
    @Override
    public void display(Grid grid) {
        if (Objects.equals(grid.getGridColor(), "red")){
            System.out.print("\u001B[31m" + grid.getGridSymbol() + "\u001B[0m" + " |");
        }
        else if (Objects.equals(grid.getGridColor(), "green")){
            System.out.print("\u001B[32m" + grid.getGridSymbol() + "\u001B[0m" + " |");
        }
        else if (Objects.equals(grid.getGridColor(), "yellow")){
            System.out.print("\u001B[33m" + grid.getGridSymbol() + "\u001B[0m" + " |");
        }
        else if (Objects.equals(grid.getGridColor(), "blue")){
            System.out.print("\u001B[34m" + grid.getGridSymbol() + "\u001B[0m" + " |");
        }
        else if (Objects.equals(grid.getGridColor(), "purple")){
            System.out.print("\u001B[35m" + grid.getGridSymbol() + "\u001B[0m" + " |");
        }
        else if (Objects.equals(grid.getGridColor(), "cyan")){
            System.out.print("\u001B[36m" + grid.getGridSymbol() + "\u001B[0m" + " |");
        }
        else{
            System.out.print("  |");
        }
    }
}
