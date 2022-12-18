package model;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.setUpBoard();
        game.setUpPlayers();
        game.playGame();
    }
}