package board;

import grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoarduseSymbolTest {

    @Test
    public void testDisplay() {

        BoarduseSymbol board = new BoarduseSymbol();

        Grid grid = new Grid("X", "", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("X |", "X |");
    }
}