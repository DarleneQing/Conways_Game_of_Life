package player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    class ConcretePlayer extends Player {
        public ConcretePlayer(String name, String symbol, String color) {
            super(name, symbol, color);
        }
    }


    @Test
    public void testGetName() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testGetSymbol() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void testGetColor() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        assertEquals("red", player.getColor());
    }

    @Test
    public void testGetNumCells() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        assertEquals(4, player.getNumCells());
    }

    @Test
    public void testGetNumGens() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        assertEquals(0, player.getNumGens());
    }

    @Test
    public void testSetNumGens() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        player.setNumGens(2);
        assertEquals(2, player.getNumGens());
    }

    @Test
    public void testSetNumCells() {
        Player player = new ConcretePlayer("Alice", "X", "red");
        player.setNumCells(6);
        assertEquals(6, player.getNumCells());
    }

    @Test
    public void testPlayer_InvalidInput() {

        // Set up the expected exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call the constructor with invalid input
            new ConcretePlayer("", "X", "red");
        });

        // Verify that the exception has the expected message
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testSetNumCells_InvalidInput() {
        // Set up the test by creating an instance of the Player class
        Player player = new ConcretePlayer("Player 1", "X", "red");

        // Set up the expected exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Call the method being tested with an invalid input

            player.setNumCells(-1);
        });

        // Verify that the exception has the expected message
        assertEquals("Number of cells cannot be negative", exception.getMessage());
    }

}