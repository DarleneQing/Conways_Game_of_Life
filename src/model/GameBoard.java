package model;

import exceptions.InvalidSize;

import java.util.ArrayList;
import java.util.Objects;

import static model.Grid.GridStatus;

public class GameBoard {
    private final int rows;
    private final int cols;
    private final ArrayList<ArrayList<Grid>> game_board = new ArrayList<>();

    public GameBoard(int row, int col) {
        this.rows = row;
        this.cols = col;
    }

    public void gridBoard(boolean colorornot, String symbol1, String symbol2, String color1, String color2) throws InvalidSize{
        if (this.rows < 10 || this.rows > 50){
            throw new InvalidSize();
        }
        System.out.println("The grid has " + rows + " rows and " + cols + " columns.");

        int i, j;
        for (i = 0; i < this.rows; i++) {
            ArrayList<Grid> row = new ArrayList<>(this.cols);
            for (j = 0; j < this.cols; j++) {
                int[][] position = {{i}, {j}};
                Grid aGrid = new Grid(" ", " ", GridStatus.DEAD);
                row.add(aGrid);
            }
            game_board.add(row);
        }

        // Initial Pattern
        for (i = this.rows/2-1; i < this.rows/2+1; i++){
            for (j = (this.cols/2)/2-1; j < (this.cols/2)/2+1; j++){
                if (!colorornot){
                    game_board.get(i).set(j, new Grid(symbol1, " ", GridStatus.ALIVE_1));
                    game_board.get(i).set(this.cols-j-1, new Grid(symbol2, " ", GridStatus.ALIVE_2));
                }
                else{
                    game_board.get(i).set(j, new Grid(" ", color1, GridStatus.ALIVE_1));
                    game_board.get(i).set(this.cols-j-1, new Grid(" ", color2, GridStatus.ALIVE_2));
                }
            }
        }

    }

    public void displayBoard(boolean colorornot){
        System.out.println("Here is your game board:");

        System.out.print("   ");
        for(int i = 0; i < this.cols; i++){
            if (i < 9){
                System.out.print("0" + (i+1) + "|");
            }
            else{
                System.out.print(i+1 + "|");
            }
        }

        System.out.println();

        for(int i = 0; i < this.rows; i++){
            if (i < 9){
                System.out.print("0" + (i+1) + "|");
            }
            else{
                System.out.print(i+1 + "|");
            }
            for (int j = 0; j < this.cols; j++){
                Grid aGrid = game_board.get(i).get(j);
                if (!colorornot){
                    String this_symbol = aGrid.getGridSymbol();
                    System.out.print(this_symbol+" |");
                }
                else{
                    if (Objects.equals(aGrid.getGridColor(), "red")){
                        System.out.print("\u001B[31m" + "*" + "\u001B[0m" + " |");
                    }
                    else if (Objects.equals(aGrid.getGridColor(), "green")){
                        System.out.print("\u001B[32m" + "*" + "\u001B[0m" + " |");
                    }
                    else if (Objects.equals(aGrid.getGridColor(), "yellow")){
                        System.out.print("\u001B[33m" + "*" + "\u001B[0m" + " |");
                    }
                    else if (Objects.equals(aGrid.getGridColor(), "blue")){
                        System.out.print("\u001B[34m" + "*" + "\u001B[0m" + " |");
                    }
                    else if (Objects.equals(aGrid.getGridColor(), "purple")){
                        System.out.print("\u001B[35m" + "*" + "\u001B[0m" + " |");
                    }
                    else if (Objects.equals(aGrid.getGridColor(), "cran")){
                        System.out.print("\u001B[36m" + "*" + "\u001B[0m" + " |");
                    }
                    else{
                        System.out.print("  |");
                    }
                }
            }
            System.out.println();
        }
    }

}
