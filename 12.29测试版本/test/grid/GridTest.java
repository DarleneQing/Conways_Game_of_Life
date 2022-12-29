package grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import grid.Grid;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.IllegalArgumentException;

public class GridTest {

    @Test
    public void testGetGridSymbol() {
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);
        assertEquals("X", grid.getGridSymbol());
    }

    @Test
    public void testSetGridSymbol() {
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);
        grid.SetGridSymbol("O");
        assertEquals("O", grid.getGridSymbol());
    }

    @Test
    public void testGetGridColor() {
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);
        assertEquals("red", grid.getGridColor());
    }

    @Test
    public void testSetGridColor() {
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);
        grid.SetGridColor("blue");
        assertEquals("blue", grid.getGridColor());
    }

    @Test
    public void testGetGridStatus() {
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);
        assertEquals(Grid.GridStatus.ALIVE_1, grid.getGridStatus());
    }

    @Test
    public void testSetGridStatus() {
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);
        grid.SetGridStatus(Grid.GridStatus.ALIVE_2);
        assertEquals(Grid.GridStatus.ALIVE_2, grid.getGridStatus());
    }

    @Test
    public void testSetSymbol_InvalidInput() {
        // Set up the test by creating an instance of the Grid class
        Grid grid = new Grid("X", "red", Grid.GridStatus.ALIVE_1);

        // Set up the expected exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method being tested with an invalid input
            grid.SetGridSymbol(null);
        });

        // Verify that the exception has the expected message
        assertEquals("Symbol cannot be null or empty", exception.getMessage());
    }


}
