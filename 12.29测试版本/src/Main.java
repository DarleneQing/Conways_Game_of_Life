import Game.Game;
import exceptions.InvalidAttack;
import exceptions.InvalidNewCell;

public class Main {
    public static void main(String[] args) throws InvalidAttack, InvalidNewCell {
        Game game = new Game();
        game.setUpPlayers();
        game.setUpBoard();
        game.playGame();
    }
}