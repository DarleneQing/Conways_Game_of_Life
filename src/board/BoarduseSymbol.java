package board;

import grid.Grid;

public class BoarduseSymbol implements Board{

    @Override
    public void display(Grid grid) {
        String this_symbol = grid.getGridSymbol();
        System.out.print(this_symbol+" |");
    }
}
