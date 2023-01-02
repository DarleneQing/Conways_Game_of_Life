package main.Game;

import main.player.Player;
import main.player.PlayeruseColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameuseColor implements GameInterface{
    private final List<Player> players = new ArrayList<>();

    @Override
    public List<Player> SetupPlayers(int num) {
        for (int i = 0; i < num; i++) {
            String player_name = getPlayerName(i + 1);
            String player_color = getPlayerColor();
            this.players.add(new PlayeruseColor(player_name, player_color));
        }
        if (Objects.equals(this.players.get(0).getColor(), this.players.get(1).getColor())){
            System.out.println("The color of 2 players could not be the same!");
            this.players.clear();
            SetupPlayers(num);
        }
        return this.players;
    }

    public String getPlayerColor(){
        Scanner scanner = new Scanner(System.in);
        List<String> colorList = new ArrayList<>(6);
        colorList.add("red"); colorList.add("green"); colorList.add("yellow");
        colorList.add("blue"); colorList.add("cyan"); colorList.add("purple");

        System.out.print("Please input a color from the color list: 'red', 'green', 'yellow', 'blue', 'cyan', 'purple': ");
        String playerColor = scanner.nextLine();
        while (!colorList.contains(playerColor)) {
            System.out.print("Please type in a correct color: ");
            playerColor = scanner.nextLine();
        }

        return playerColor;
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
