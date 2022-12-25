package model;

import exceptions.InvalidAttack;
import exceptions.InvalidSize;
import static model.Grid.GridStatus;

import java.util.*;

public class Game {
    private final int numPlayers;
    private final boolean colorornot;
    private final List<Player> players = new ArrayList<>();
    private int rows;
    private int cols;
    private GameBoard aGameBoard;

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
                this.players.add(new PlayeruseSymbol(player_name, player_symbol));
            }
            if (Objects.equals(this.players.get(0).getSymbol(), this.players.get(1).getSymbol())){
                System.out.println("The symbol of 2 players could not be the same!");
                this.players.clear();
                setUpPlayers();
            }
        }
        else{
            for (int i = 0; i < this.numPlayers; i++) {
                String player_name = getPlayerName(i + 1);
                String player_color = getPlayerColor();
                this.players.add(new PlayeruseColor(player_name, player_color));
            }
            if (Objects.equals(this.players.get(0).getColor(), this.players.get(1).getColor())){
                System.out.println("The color of 2 players could not be the same!");
                this.players.clear();
                setUpPlayers();
            }
        }

        if (Objects.equals(this.players.get(0).getName(), this.players.get(1).getName())){
            System.out.println("The name of 2 players could not be the same!");
            this.players.clear();
            setUpPlayers();
        }

        this.players.sort(Comparator.comparing(Player::getName));
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
        this.rows = scanner.nextInt();
        this.cols = 2 * rows;

        // Setup
        try{
            this.aGameBoard = new GameBoard(this.rows, this.cols);
            this.aGameBoard.gridBoard(colorornot, players.get(0).getSymbol(), players.get(1).getSymbol(), players.get(0).getColor(), players.get(1).getColor());
            this.aGameBoard.displayBoard(colorornot);
        }
        catch (InvalidSize e) {
            System.out.println("Invalid input. Please input an integer between 10-50.");
            setUpBoard();
        }
    }

    public void playGame() throws InvalidAttack {
        Player player1 = this.players.get(0);
        Player player2 = this.players.get(1);

        System.out.println("The order is: first " + player1.getName() + " and then " + player2.getName());
        System.out.println(player1.getName() + "'s initial cells are at the left part and " + player2.getName() + "'s initial cells are at the right part.");

        while (player1.getNumCells()>0 && player2.getNumCells()>0){
            for(int i = 0; i < this.numPlayers; i++){
                try {
                    attack(i);
                }
                catch (InvalidAttack e) {
                    System.out.println("Invalid input. Please input the coordinate of one of your opponent's cells");
                    attack(i);
                }


                int num1 = 0;
                int num2 = 0;
                for(int j=0; j<this.rows; j++){
                    for(int k=0; k<this.cols; k++){
                        if(this.aGameBoard.GetContent(j, k).getGridStatus() == GridStatus.ALIVE_1){
                            num1 ++;
                        }
                        if(this.aGameBoard.GetContent(j, k).getGridStatus() == GridStatus.ALIVE_2){
                            num2 ++;
                        }
                    }
                }
                player1.setNumCells(num1);
                player2.setNumCells(num2);
                this.aGameBoard.displayBoard(colorornot);

            }
        }
    }


    public void attack(int i) throws InvalidAttack {
        Scanner scanner = new Scanner(System.in);

        System.out.print(this.players.get(i).getName() + ", please input the row number of one of your opponent's cells that you want to attack:");
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input, please input an integer:");
            scanner.nextLine();
        }
        int row = scanner.nextInt();

        System.out.print(this.players.get(i).getName() + ", please input the column number of one of your opponent's cells that you want to attack:");
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input, please input an integer:");
            scanner.nextLine();
        }
        int col = scanner.nextInt();

        if(i == 0) {
            if (row <= 0 || row > this.rows || col <= 0 || col > this.cols || this.aGameBoard.GetContent(row - 1, col - 1).getGridStatus() != GridStatus.ALIVE_2) {
                throw new InvalidAttack();
            }
        }

        if(i == 1) {
            if (row <= 0 || row > this.rows || col <= 0 || col > this.cols || this.aGameBoard.GetContent(row - 1, col - 1).getGridStatus() != GridStatus.ALIVE_1) {
                throw new InvalidAttack();
            }
        }
        this.aGameBoard.GetContent(row-1, col-1).SetGridStatus(GridStatus.DEAD);
        this.aGameBoard.GetContent(row-1, col-1).SetGridSymbol(" ");

    }

    public void Generation(){

    }
}
