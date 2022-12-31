package Game;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import main.Game.ConcreteGameImplementation;
import main.Game.GameContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.player.Player;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameContextTest {
    private GameContext context;
    private ConcreteGameImplementation game;

    @BeforeEach
    public void setup() {
        game = new ConcreteGameImplementation();
        context = new GameContext(game);
    }

    @Test
    public void testSetupPlayers() {
        int numPlayers = 0;
        if (numPlayers == 0) {
            throw new IllegalArgumentException("Number of players must be 2 ");
        }
        List<Player> players = context.SetupPlayers(numPlayers);
        assertNotNull(players);
        assertEquals(numPlayers, players.size());
    }


    @Test
    public void testSetupPlayers_Normal() {
        GameContext context = new GameContext(new ConcreteGameImplementation());
        List<Player> players = context.SetupPlayers(2);
        assertEquals(2, players.size());
    }

    @Test
    public void testSetupPlayers_Negative() {
        GameContext context = new GameContext(new ConcreteGameImplementation());
        assertThrows(IllegalArgumentException.class, () -> context.SetupPlayers(-1));
    }

    @Test
    public void testSetupPlayers_Zero() {
        GameContext context = new GameContext(new ConcreteGameImplementation());
        assertThrows(IllegalArgumentException.class, () -> context.SetupPlayers(0));
    }


}
