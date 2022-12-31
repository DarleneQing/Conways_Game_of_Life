package main.board;

import main.grid.Grid;

public class BoardContext {
    private final Board board;

    public BoardContext(Board board){
        this.board = board;
    }

    public void display(Grid grid){
        board.display(grid);
    }
}
