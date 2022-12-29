package board;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exceptions.InvalidSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameBoardTest {

    private GameBoard board;

    @BeforeEach
    public void setup() {
        board = new GameBoard(10, 10);
    }

    @Test
    public void testConstructor() {
        assertNotNull(board);
        assertEquals(10, board.getRows());
        assertEquals(10, board.getCols());
    }

    @Test
    public void testConstructor_InvalidSize() {
        assertThrows(InvalidSize.class, () -> new GameBoard(9, 10));
        assertThrows(InvalidSize.class, () -> new GameBoard(51, 10));
        assertThrows(InvalidSize.class, () -> new GameBoard(10, 9));
        assertThrows(InvalidSize.class, () -> new GameBoard(10, 51));
    }


    @Test
    public void testGetContent() {
        Grid grid = board.GetContent(0, 0);
        assertNotNull(grid);
        assertEquals(" ", grid.getGridSymbol());
        assertEquals(" ", grid.getGridColor());
    }

    @Test
    public void testDisplayBoard() {
        // Test with color = false
        GameBoard board = new GameBoard(10, 10);
        board.displayBoard(false);

        // Test with color = true
        board = new GameBoard(10, 10);
        board.displayBoard(true);
    }

    // Test the GetContent method
    @Test
    public void testGetContent1() {
        GameBoard board = new GameBoard(10, 10);
        Grid grid = board.GetContent(0, 0);
        assertNotNull(grid);
    }

    @Test
    public void testGridBoard_Symbols() throws InvalidSize {
        board.gridBoard(false, "X", "O", " ", " ");

        assertEquals("X", board.GetContent(4, 4).getGridSymbol());
        assertEquals("O", board.GetContent(4, 5).getGridSymbol());
        assertEquals("O", board.GetContent(4, 6).getGridSymbol());
        assertEquals("X", board.GetContent(4, 7).getGridSymbol());

        assertEquals(" ", board.GetContent(4, 4).getGridColor());
        assertEquals(" ", board.GetContent(4, 5).getGridColor());
        assertEquals(" ", board.GetContent(4, 6).getGridColor());
        assertEquals(" ", board.GetContent(4, 7).getGridColor());
    }

    @Test
    public void testGridBoard_Colors() throws InvalidSize {
        board.gridBoard(true, "X", "O", "31", "32");

        assertEquals("X", board.GetContent(4, 4).getGridSymbol());
        assertEquals("O", board.GetContent(4, 5).getGridSymbol());
        assertEquals("O", board.GetContent(4, 6).getGridSymbol());
        assertEquals("X", board.GetContent(4, 7).getGridSymbol());

        assertEquals("31", board.GetContent(4, 4).getGridColor());
        assertEquals("32", board.GetContent(4, 5).getGridColor());
        assertEquals("32", board.GetContent(4, 6).getGridColor());
        assertEquals("31", board.GetContent(4, 7).getGridColor());

    }
}