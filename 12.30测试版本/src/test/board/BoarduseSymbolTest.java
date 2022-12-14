package board;
import main.grid.Grid;
import main.board.BoarduseSymbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoarduseSymbolTest {

    @Test
    public void testDisplay() {

        BoarduseSymbol board = new BoarduseSymbol();

        Grid grid = new Grid("X", "", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("X |", "X |");
    }
}