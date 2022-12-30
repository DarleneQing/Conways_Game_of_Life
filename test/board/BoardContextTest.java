package board;

import grid.Grid;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardContextTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testDisplay() {
        BoarduseColor board = new BoarduseColor();

        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);

        BoardContext context = new BoardContext(board);

        context.display(grid);

        assertEquals("\u001B[31mX\u001B[0m |","\u001B[31mX\u001B[0m |");
    }
}