
package Game;
import static org.junit.jupiter.api.Assertions.*;
import board.GameBoard;
import exceptions.InvalidAttack;
import exceptions.InvalidNewCell;
import player.Player;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameTest {
    private Game game;
    private GameBoard board;
    private Player player1;
    private Player player2;

    public GameTest() {
        game = new Game();
        game.setUpPlayers();
        game.setUpBoard();
        board = game.getBoard();
        player1 = game.getPlayers().get(0);
        player2 = game.getPlayers().get(1);
    }

    @Test
    public void testGetBoard() {
        assertNotNull(game.getBoard());
        assertEquals(game.getBoard(), board);
    }

    @Test
    public void testGetPlayers() {
        assertNotNull(game.getPlayers());
        assertEquals(2, game.getPlayers().size());
        assertEquals(game.getPlayers().get(0), player1);
        assertEquals(game.getPlayers().get(1), player2);
    }

}