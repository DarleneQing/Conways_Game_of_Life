package main.Game;

import main.player.Player;

import java.util.List;

public class GameContext {
    private final GameInterface game;

    public GameContext(GameInterface game) {
        this.game = game;
    }

    public List<Player> SetupPlayers(int num){
        return game.SetupPlayers(num);
    }
}
