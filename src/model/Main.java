package model;

public class Main {
    public static void main(String[] args) {
        GameControl game = new GameControl();
        game.setUpBoard();
        game.setUpPlayers();
        game.playGame();
    }
}