
package board;

import main.grid.Grid;
import main.board.BoardContext;
import main.board.BoarduseColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BoardContextTest {

    @Test
    public void testDisplay() {
        BoarduseColor board = new BoarduseColor();

        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);

        BoardContext context = new BoardContext(board);

        context.display(grid);

        assertEquals("\u001B[31mX\u001B[0m |","\u001B[31mX\u001B[0m |");
    }
}
