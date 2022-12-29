package Game;
import static org.junit.jupiter.api.Assertions.*;
import player.Player;
import org.junit.jupiter.api.Test;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameuseSymbolTest {

    @Test
    public void testSetupPlayers() {
        GameuseSymbol gameuseSymbol = new GameuseSymbol();
        List<Player> players = gameuseSymbol.SetupPlayers(2);
        assertEquals(2, players.size());
        assertEquals("Player M ", players.get(0).getName());
        assertEquals("Player Z ", players.get(1).getName());
        assertEquals("!", players.get(0).getSymbol());
        assertEquals("$", players.get(1).getSymbol());
    }
}
