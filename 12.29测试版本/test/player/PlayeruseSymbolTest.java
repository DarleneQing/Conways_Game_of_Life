package player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import player.PlayeruseSymbol;

public class PlayeruseSymbolTest {

    @Test
    public void testGetName() {
        PlayeruseSymbol player = new PlayeruseSymbol("Alice", "X");
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testGetSymbol() {
        PlayeruseSymbol player = new PlayeruseSymbol("Alice", "X");
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void testGetColor() {
        PlayeruseSymbol player = new PlayeruseSymbol("Alice", "X");
        assertEquals("", player.getColor());
    }

    @Test
    public void testGetNumCells() {
        PlayeruseSymbol player = new PlayeruseSymbol("Alice", "X");
        assertEquals(4, player.getNumCells());
    }
}