package Game;
import static org.junit.jupiter.api.Assertions.*;
import player.Player;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameuseColorTest {
    private GameuseColor gameuseColor;

    @Test
    public void testSetupPlayers() {
        gameuseColor = new GameuseColor();
        int numPlayers = 2;
        List<Player> players = gameuseColor.SetupPlayers(numPlayers);
        assertNotNull(players);
        assertEquals(numPlayers, players.size());
    }

    @Test
    public void testGetPlayerColor() {
        gameuseColor = new GameuseColor();
        String color = gameuseColor.getPlayerColor();
        assertNotNull(color);
    }

    @Test
    public void testGetPlayerName() {
        gameuseColor = new GameuseColor();
        int num = 1;
        String name = gameuseColor.getPlayerName(num);
        assertNotNull(name);
    }

    @Test
    public void testSetupPlayers2() {
        gameuseColor = new GameuseColor();

        // Test for 2 players
        List<Player> players = gameuseColor.SetupPlayers(2);
        assertNotNull(players);
        assertEquals(2, players.size());
        assertEquals("Player 1", players.get(0).getName());
        assertEquals("red", players.get(0).getColor());
        assertEquals("Player 2", players.get(1).getName());
        assertEquals("green", players.get(1).getColor());

        players = gameuseColor.SetupPlayers(1);
        assertNotNull(players);
        assertEquals(1, players.size());
        assertEquals("Invalid Player", players.get(0).getName());
        assertEquals("red", players.get(0).getColor());
    }
}
