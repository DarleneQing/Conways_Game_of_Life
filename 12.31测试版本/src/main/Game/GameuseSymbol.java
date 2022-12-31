package main.Game;

import main.player.Player;
import main.player.PlayeruseSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameuseSymbol implements GameInterface{
    private final List<Player> players = new ArrayList<>();

    @Override
    public List<Player> SetupPlayers(int num) {
        for (int i = 0; i < num; i++) {
            String player_name = getPlayerName(i + 1);
            String player_symbol = getPlayerSymbol();
            this.players.add(new PlayeruseSymbol(player_name, player_symbol));
        }
        if (Objects.equals(this.players.get(0).getSymbol(), this.players.get(1).getSymbol())){
            System.out.println("The symbol of 2 players could not be the same!");
            this.players.clear();
            SetupPlayers(num);
        }
        return this.players;
    }

    public String getPlayerSymbol() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input a single sign as your symbol (not letters or numbers): ");
        String playerSymbol = scanner.nextLine();
        while (!playerSymbol.matches("\\W")) {
            System.out.print("Please type in a correct symbol: ");
            playerSymbol = scanner.nextLine();
        }

        return playerSymbol;
    }

    public String getPlayerName(int num){
        Scanner scanner = new Scanner(System.in);

        // Read the name of players
        System.out.print("please input name " + num + ": ");
        String playerName = scanner.nextLine();
        while(!playerName.matches("([A-Z][a-z]*\\s)+[A-Z][a-z]*")){
            System.out.print("Please input a valid name according to the rules: ");
            playerName = scanner.nextLine();
        }

        return playerName;
    }
}
