package test;

import model.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    private Grid gridUnderTest;

    @BeforeEach
    void setUp() {
        gridUnderTest = new Grid("grid_symbol", "grid_color", Grid.GridStatus.ALIVE_1);
    }

    @Test
    void testGetGridSymbol() {
        assertEquals("grid_symbol", gridUnderTest.getGridSymbol());
    }

    @Test
    void testGetGridColor() {
        assertEquals("grid_color", gridUnderTest.getGridColor());
    }

    @Test
    void testGetGridStatus() {
        assertEquals(Grid.GridStatus.ALIVE_1, gridUnderTest.getGridStatus());
    }

    @Test
    void testSetTempstatus() {
        // Setup
        // Run the test
        gridUnderTest.SetTempstatus(Grid.GridStatus.ALIVE_1);

        // Verify the results
    }

    @Test
    void testSetGridStatus() {
        // Setup
        // Run the test
        gridUnderTest.SetGridStatus(Grid.GridStatus.ALIVE_1);

        // Verify the results
    }

    @Test
    void testSetGridSymbol() {
        // Setup
        // Run the test
        gridUnderTest.SetGridSymbol("symbol");

        // Verify the results
    }

    @Test
    void testSetGridColor() {
        // Setup
        // Run the test
        gridUnderTest.SetGridColor("color");

        // Verify the results
    }
}
