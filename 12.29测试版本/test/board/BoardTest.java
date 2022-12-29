package board;
import exceptions.InvalidSize;

import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new BoarduseSymbol();
    }

    @Test
    public void testDisplay() {

        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[31mX\u001B[0m |", null);
    }
}
