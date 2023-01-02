package main;

import main.Game.Game;
import main.exceptions.InvalidAttack;
import main.exceptions.InvalidNewCell;

public class Main {
    // only for test
    public static int test() {
        return 1;
    }
    public static void main(String[] args) throws InvalidAttack, InvalidNewCell {
        Game game = new Game();
        game.setUpPlayers();
        game.setUpBoard();
        game.playGame();
    }
}
