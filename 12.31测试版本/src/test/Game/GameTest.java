package Game;

import main.Game.Game;
import main.board.GameBoard;
import main.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class GameTest {
    // Use @Mock annotation to create mock object

    private Game game;
    private GameBoard board;
    private Player player1;
    private Player player2;
    @Mock
    private Player playerMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlayerMovement() {

        int oldRow = playerMock.getRow();
        int oldCol = playerMock.getCol();
        playerMock.move();
        assertNotEquals(oldRow, playerMock.getRow());
        assertNotEquals(oldCol, playerMock.getCol());
    }


    @Test
    public void testMovement() {
        Player playerMock = Mockito.mock(Player.class);
        int oldRow = playerMock.getRow();
        int oldCol = playerMock.getCol();
        playerMock.move();
        assertNotEquals(oldRow, playerMock.getRow());
        assertNotEquals(oldCol, playerMock.getCol());
    }



    @Test
    public void testConstructor() {
        assertNotNull(game.getPlayers());
        assertNotNull(game.getBoard());
    }


    @Test
    public void testSetUpPlayers() {
        assertEquals(game.getPlayers().size(), 2);
    }

    @Test
    public void testGetBoard() {
        assertNotNull(game.getBoard());
        assertEquals(game.getBoard(), board);
    }


}