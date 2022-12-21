package model;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.setUpPlayers();
        game.setUpBoard();
        game.playGame();
    }
}