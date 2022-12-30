
package Game;
import static org.junit.jupiter.api.Assertions.*;

import main.Game.Game;
import main.board.GameBoard;
import main.player.Player;

import org.junit.jupiter.api.Test;

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



}