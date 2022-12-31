package player;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.player.PlayeruseColor;

public class PlayeruseColorTest {

    @Test
    public void testGetName() {
        PlayeruseColor player = new PlayeruseColor("Alice", "red");
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testGetSymbol() {
        PlayeruseColor player = new PlayeruseColor("Alice", "red");
        assertEquals("*", player.getSymbol());
    }

    @Test
    public void testGetColor() {
        PlayeruseColor player = new PlayeruseColor("Alice", "red");
        assertEquals("red", player.getColor());
    }

    @Test
    public void testGetNumCells() {
        PlayeruseColor player = new PlayeruseColor("Alice", "red");
        assertEquals(4, player.getNumCells());
    }

    @Test
    public void testGetNumGens() {
        PlayeruseColor player = new PlayeruseColor("Alice", "red");
        assertEquals(0, player.getNumGens());
    }


    @Test
    public void testSetNumCells() {
        PlayeruseColor player = new PlayeruseColor("Alice", "red");
        player.setNumCells(6);
        assertEquals(6, player.getNumCells());
    }

    @Test
    public void testPlayer_InvalidInput() {
        // Set up the expected exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call the constructor with invalid input
            new PlayeruseColor("", "red");
        });

        // Verify that the exception has the expected message
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testSetNumCells_InvalidInput() {
        // Set up the test by creating an instance of the PlayeruseColor class
        PlayeruseColor player = new PlayeruseColor("Player 1", "red");

        // Set up the expected exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method being tested with an invalid input
            player.setNumCells(-1);
        });

        // Verify that the exception has the expected message
        assertEquals("Number of cells cannot be negative", exception.getMessage());
    }

}
