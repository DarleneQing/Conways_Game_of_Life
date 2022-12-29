package board;

import exceptions.InvalidSize;

import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BoarduseColorTest {

    @Test
    public void testDisplay_RedColor() {

        BoarduseColor board = new BoarduseColor();
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[31mX\u001B[0m |", null);
    }

    @Test
    public void testDisplay_GreenColor() {

        BoarduseColor board = new BoarduseColor();
        Grid grid = new Grid("X", "green", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[32mX\u001B[0m |", null);
    }

    @Test
    public void testDisplay_YellowColor() {

        BoarduseColor board = new BoarduseColor();
        Grid grid = new Grid("X", "yellow",Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[33mX\u001B[0m |", null);
    }

    @Test
    public void testDisplay_BlueColor() {

        BoarduseColor board = new BoarduseColor();
        Grid grid = new Grid("X", "blue", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[34mX\u001B[0m |", null);
    }
    @Test
    public void testDisplay_Purple() {

        BoarduseColor board = new BoarduseColor();
        Grid grid = new Grid("X", "purple", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[34mX\u001B[0m |", null);
    }

    @Test
    public void testDisplay_Cran() {

        BoarduseColor board = new BoarduseColor();

        Grid grid = new Grid("X", "cran", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("\u001B[34mX\u001B[0m |", null);
    }
    @Test
    public void testDisplay_EmptyStringColor() {

        BoarduseColor board = new BoarduseColor();
        Grid grid = new Grid("X", "", Grid.GridStatus.ALIVE_1);

        board.display(grid);

        assertEquals("  |", null);
    }


}
