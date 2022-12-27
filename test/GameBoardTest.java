package test;

import exceptions.InvalidSize;
import model.GameBoard;
import model.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameBoardTest {

    private GameBoard gameBoardUnderTest;

    @BeforeEach
    void setUp() {
        gameBoardUnderTest = new GameBoard(0, 0);
    }

    @Test
    void testGridBoard() throws Exception {
        // Setup
        // Run the test
        gameBoardUnderTest.gridBoard(false, "symbol1", "symbol1", "color1", "color1");

        // Verify the results
    }

    @Test
    void testGridBoard_ThrowsInvalidSize() {
        // Setup
        // Run the test
        assertThrows(InvalidSize.class,
                () -> gameBoardUnderTest.gridBoard(false, "symbol1", "symbol1", "color1", "color1"));
    }

    @Test
    void testDisplayBoard() {
        // Setup
        // Run the test
        gameBoardUnderTest.displayBoard(false);

        // Verify the results
    }

    @Test
    void testGetContent() {
        // Setup
        // Run the test
        final Grid result = gameBoardUnderTest.GetContent(0, 0);

        // Verify the results
    }
}
