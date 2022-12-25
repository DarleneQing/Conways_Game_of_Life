package model;

import exceptions.InvalidAttack;

public class Main {
    public static void main(String[] args) throws InvalidAttack {
        Game game = new Game();
        game.setUpPlayers();
        game.setUpBoard();
        game.playGame();
    }
}