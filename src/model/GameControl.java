package model;

import exceptions.InvalidSize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GameControl {

    private final int numPlayers;
    private final List<Player> players = new ArrayList<>();

    public GameControl() {
        this.numPlayers = 2;
    }

    public void setUpBoard(){
        Scanner scanner = new Scanner(System.in);

        // Read the size of the grid
        System.out.print("Enter the number of rows(an integer between 10-100): ");
        while(!scanner.hasNextInt()){
            System.out.println("Invalid input. Please input an integer between 10-100.");
            System.out.print("Enter the number of rows(an integer between 10-100): ");
            scanner.nextLine();
        }
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns(a number between 10-100): ");
        while(!scanner.hasNextInt()){
            System.out.println("Invalid input. Please input an integer between 10-100.");
            System.out.print("Enter the number of rows(an integer between 10-100): ");
            scanner.nextLine();
        }
        int cols = scanner.nextInt();

        // Setup
        try{
            Grid grid = new Grid(rows, cols);
        }
        catch (InvalidSize e) {
            System.out.println("Invalid input. Please input an integer between 10-100.");
            setUpBoard();
        }
    }

    public void setUpPlayers(){
        for (int i = 0; i < numPlayers; i++) {
            String playername = getPlayerName();
            String playersymbol = getPlayerSymbol();
            players.add(new Player(playername, playersymbol));
        }

        players.sort(Comparator.comparing(Player::getName));
    }

    public String getPlayerName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("please input your name: ");
        String playerName = scanner.nextLine();
        while (playerName.length() < 1) {
            System.out.print("Please type in some name: ");
            playerName = scanner.nextLine();
        }

        return playerName;
    }

    public String getPlayerSymbol() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("please input a single capital letter from A-Z as your symbol: ");
            String playerSymbol = scanner.nextLine();
            char c = playerSymbol.charAt(0);
            while (playerSymbol.length() < 1 || playerSymbol.length() > 2 || !Character.isUpperCase(c)) {
                System.out.print("Please type in a correct symbol: ");
                playerSymbol = scanner.nextLine();
            }

            return playerSymbol;
    }

    public void playGame(){

    }
}
