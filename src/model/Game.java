package model;

import exceptions.InvalidSize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final List<Player> players = new ArrayList<>();

    private GameBoard aGameBoard;

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
            aGameBoard = new GameBoard(rows, cols);
            aGameBoard.displayBoard(rows, cols);
        }
        catch (InvalidSize e) {
            System.out.println("Invalid input. Please input an integer between 10-100.");
            setUpBoard();
        }

        aGameBoard.gridBoard();
    }

    public void setUpPlayers(){
        int num_player = 2;

        for (int i = 0; i < num_player; i++) {
            String player_name = getPlayerName();
            String player_symbol = getPlayerSymbol();
            players.add(new Player(player_name, player_symbol));
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

    public void initialPattern(){

    }

    public void playGame(){
        Player player1 = players.get(0);
        Player player2 = players.get(1);


    }
}
