package model;

import exceptions.InvalidSize;

import java.util.*;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final int numPlayers;
    private final boolean colorornot;

    public Game() {
        this.numPlayers = 2;
        this.colorornot = getPlayerSymbolorColor();
    }

    public void setUpPlayers(){
        System.out.println("Rules for inputting names: Please input your first name, middle names(optional) and last name, using upper-case for first letters. Please use a whitespace to separate them)");
        if (!this.colorornot) {
            for (int i = 0; i < this.numPlayers; i++) {
                String player_name = getPlayerName(i + 1);
                String player_symbol = getPlayerSymbol();
                players.add(new PlayeruseSymbol(player_name, player_symbol));
            }
        }
        else{
            for (int i = 0; i < this.numPlayers; i++) {
                String player_name = getPlayerName(i + 1);
                String player_color = getPlayerColor();
                players.add(new PlayeruseColor(player_name, player_color));
            }
        }

        if (Objects.equals(players.get(0).getName(), players.get(1).getName())){
            System.out.println("The name of 2 players could not be the same!");
            setUpPlayers();
        }

        players.sort(Comparator.comparing(Player::getName));
    }

    public boolean getPlayerSymbolorColor(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to use different symbols or different colors to distinguish from each other? Please input 'symbol' or 'color':");
        String SymbolorColor = scanner.nextLine();
        while (!Objects.equals(SymbolorColor, "symbol") && !Objects.equals(SymbolorColor, "color")){
            System.out.print("Please select from 'symbol' and 'color':");
            SymbolorColor = scanner.nextLine();
        }

        // symbol: 0, color: 1
        return SymbolorColor.equals("color");
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

    public String getPlayerColor(){
        Scanner scanner = new Scanner(System.in);
        List<String> colorList = new ArrayList<>(6);
        colorList.add("red"); colorList.add("green"); colorList.add("yellow");
        colorList.add("blue"); colorList.add("cran"); colorList.add("purple");

        System.out.print("Please input a color from the color list: 'red', 'green', 'yellow', 'blue', 'cran', 'purple': ");
        String playerColor = scanner.nextLine();
        while (!colorList.contains(playerColor)) {
            System.out.print("Please type in a correct color: ");
            playerColor = scanner.nextLine();
        }

        return playerColor;
    }

    public void setUpBoard(){
        Scanner scanner = new Scanner(System.in);

        // Read the size of the grid
        System.out.print("Enter the number of rows(an integer between 10-50): ");
        while(!scanner.hasNextInt()){
            System.out.println("Invalid input. Please input an integer between 10-50.");
            System.out.print("Enter the number of rows(an integer between 10-50): ");
            scanner.nextLine();
        }
        int rows = scanner.nextInt();
        int cols = 2 * rows;

        // Setup
        try{
            GameBoard aGameBoard = new GameBoard(rows, cols);
            aGameBoard.gridBoard();
            aGameBoard.displayBoard();
        }
        catch (InvalidSize e) {
            System.out.println("Invalid input. Please input an integer between 10-50.");
            setUpBoard();
        }
    }


    public void initialPattern(){

    }

    public void playGame(){
        Player player1 = players.get(0);
        Player player2 = players.get(1);


    }
}
