package test;

import exceptions.InvalidAttack;
import exceptions.InvalidNewCell;
import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game gameUnderTest;

    @BeforeEach
    void setUp() {
        gameUnderTest = new Game();
    }

    @Test
    void testSetUpPlayers() {
        // Setup
        // Run the test
        gameUnderTest.setUpPlayers();

        // Verify the results
    }

    @Test
    void testGetPlayerSymbolorColor() {
        assertFalse(gameUnderTest.getPlayerSymbolorColor());
    }

    @Test
    void testGetPlayerName() {
        assertEquals("name", gameUnderTest.getPlayerName(0));
    }

    @Test
    void testGetPlayerSymbol() {
        assertEquals("symbol", gameUnderTest.getPlayerSymbol());
    }

    @Test
    void testGetPlayerColor() {
        assertEquals("color", gameUnderTest.getPlayerColor());
    }

    @Test
    void testSetUpBoard() {
        // Setup
        // Run the test
        gameUnderTest.setUpBoard();

        // Verify the results
    }

    @Test
    void testPlayGame() throws Exception {
        // Setup
        // Run the test
        gameUnderTest.playGame();

        // Verify the results
    }

    @Test
    void testPlayGame_ThrowsInvalidAttack() {
        // Setup
        // Run the test
        assertThrows(InvalidAttack.class, () -> gameUnderTest.playGame());
    }

    @Test
    void testPlayGame_ThrowsInvalidNewCell() {
        // Setup
        // Run the test
        assertThrows(InvalidNewCell.class, () -> gameUnderTest.playGame());
    }

    @Test
    void testTryattack() throws Exception {
        // Setup
        // Run the test
        gameUnderTest.tryattack(0);

        // Verify the results
    }

    @Test
    void testTryattack_ThrowsInvalidAttack() {
        // Setup
        // Run the test
        assertThrows(InvalidAttack.class, () -> gameUnderTest.tryattack(0));
    }

    @Test
    void testAttack() throws Exception {
        // Setup
        // Run the test
        gameUnderTest.attack(0);

        // Verify the results
    }

    @Test
    void testAttack_ThrowsInvalidAttack() {
        // Setup
        // Run the test
        assertThrows(InvalidAttack.class, () -> gameUnderTest.attack(0));
    }

    @Test
    void testTrynewcell() throws Exception {
        // Setup
        // Run the test
        gameUnderTest.trynewcell(0);

        // Verify the results
    }

    @Test
    void testTrynewcell_ThrowsInvalidNewCell() {
        // Setup
        // Run the test
        assertThrows(InvalidNewCell.class, () -> gameUnderTest.trynewcell(0));
    }

    @Test
    void testNewCell() throws Exception {
        // Setup
        // Run the test
        gameUnderTest.newCell(0);

        // Verify the results
    }

    @Test
    void testNewCell_ThrowsInvalidNewCell() {
        // Setup
        // Run the test
        assertThrows(InvalidNewCell.class, () -> gameUnderTest.newCell(0));
    }

    @Test
    void testGeneration() {
        // Setup
        // Run the test
        gameUnderTest.Generation();

        // Verify the results
    }
}
