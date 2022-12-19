package model;

import exceptions.InvalidSize;

import java.util.ArrayList;

import static model.Grid.GridStatus;

public class GameBoard {
    private final int rows;
    private final int cols;
    private final ArrayList<ArrayList<Grid>> game_board = new ArrayList<>();

    public GameBoard(int row, int col) {
        this.rows = row;
        this.cols = col;
    }

    public void gridBoard() throws InvalidSize{
        if (this.rows < 10 || this.rows > 100 || this.cols < 10 || this.cols > 100){
            throw new InvalidSize();
        }
        System.out.println("The grid has " + rows + " rows and " + cols + " columns.");

        int i, j;
        for (i = 0; i < this.rows; i++) {
            ArrayList<Grid> row = new ArrayList<>(this.cols);
            for (j = 0; j < this.cols; j++) {
                int[][] position = {{i}, {j}};
                Grid aGrid = new Grid(false, " ", "", GridStatus.DEAD, position);
                row.add(aGrid);
            }
            game_board.add(row);
        }
    }


    public void displayBoard(){
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
                String this_symbol = aGrid.getGridSymbol();
                System.out.print(this_symbol+" |");
            }
            System.out.println();
        }
    }

}
