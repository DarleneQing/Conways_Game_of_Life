package Game;

import exceptions.InvalidAttack;
import exceptions.InvalidNewCell;
import exceptions.InvalidSize;
import board.GameBoard;
import player.Player;
import player.PlayeruseColor;
import player.PlayeruseSymbol;

import static grid.Grid.GridStatus;

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
        System.out.println("Rules for inputting names: Please input your first name, middle names(optional) and last name, using upper-case for first letters. Please use a whitespace to separate them.");
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

        System.out.print("Do you want to use different symbols or different colors to distinguish from each other? Please input 'symbol' or 'color': ");
        String SymbolorColor = scanner.nextLine();
        while (!Objects.equals(SymbolorColor, "symbol") && !Objects.equals(SymbolorColor, "color")){
            System.out.print("Please select from 'symbol' and 'color': ");
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
            this.aGameBoard.gridBoard(this.colorornot, this.players.get(0).getSymbol(), this.players.get(1).getSymbol(), this.players.get(0).getColor(), this.players.get(1).getColor());
            this.aGameBoard.displayBoard(this.colorornot);
        }
        catch (InvalidSize e) {
            System.out.println("Invalid input. Please input an integer between 10-50.");
            setUpBoard();
        }
    }

    public void playGame() throws InvalidAttack, InvalidNewCell {
        Player player1 = this.players.get(0);
        Player player2 = this.players.get(1);

        System.out.println("The order is: first " + player1.getName() + " and then " + player2.getName() + ".");
        System.out.println(player1.getName() + "'s initial cells are at the left part and " + player2.getName() + "'s initial cells are at the right part.");

        while (player1.getNumCells()>0 && player2.getNumCells()>0){
            for(int i = 0; i < this.numPlayers; i++){
                tryattack(i);
                trynewcell(i);
                Generation();
                player1.setNumGens(player1.getNumGens()+1);
                player2.setNumGens(player2.getNumGens()+1);

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

        if (player1.getNumCells() == 0){
            System.out.println(player2.getName() + " wins the game!");
        }

        if (player2.getNumCells() == 0){
            System.out.println(player1.getName() + " wins the game!");
        }

        if (player1.getNumCells() == 0 && player2.getNumCells() == 0){
            System.out.println("Nobody wins the game!");
        }
    }

    public void tryattack(int i) throws InvalidAttack {
        try {
            attack(i);
        }
        catch (InvalidAttack e) {
            System.out.println("Invalid input. Please input the coordinate of one of your opponent's live cells!");
            tryattack(i);
        }
    }

    public void attack(int i) throws InvalidAttack {
        Scanner scanner = new Scanner(System.in);

        System.out.print(this.players.get(i).getName() + ", please input the row number of one of your opponent's live cells that you want to attack: ");
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input, please input an integer: ");
            scanner.nextLine();
        }
        int row = scanner.nextInt();

        System.out.print(this.players.get(i).getName() + ", please input the column number of one of your opponent's live cells that you want to attack: ");
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input, please input an integer: ");
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

    public void trynewcell(int i) throws InvalidNewCell {
        try {
            newCell(i);
        }
        catch (InvalidNewCell e) {
            System.out.println("Invalid input. Please input the coordinate of one dead cell.");
            trynewcell(i);
        }
    }

    public void newCell(int i) throws InvalidNewCell {
        Scanner scanner = new Scanner(System.in);

        System.out.print(this.players.get(i).getName() + ", please input the row number of the coordinate that you want to add a new live cell: ");
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input, please input an integer: ");
            scanner.nextLine();
        }
        int row = scanner.nextInt();

        System.out.print(this.players.get(i).getName() + ", please input the column number of the coordinate that you want to add a new live cell: ");
        while(!scanner.hasNextInt()){
            System.out.print("Invalid input, please input an integer: ");
            scanner.nextLine();
        }
        int col = scanner.nextInt();

        if (row <= 0 || row > this.rows || col <= 0 || col > this.cols || this.aGameBoard.GetContent(row - 1, col - 1).getGridStatus() != GridStatus.DEAD) {
                throw new InvalidNewCell();
        }

        if (i == 0){
            this.aGameBoard.GetContent(row-1, col-1).SetGridStatus(GridStatus.ALIVE_1);
            this.aGameBoard.GetContent(row-1, col-1).SetGridSymbol(this.players.get(0).getSymbol());
            if(this.colorornot){
                this.aGameBoard.GetContent(row-1, col-1).SetGridColor(this.players.get(0).getColor());
            }
        }

        if (i == 1){
            this.aGameBoard.GetContent(row-1, col-1).SetGridStatus(GridStatus.ALIVE_2);
            this.aGameBoard.GetContent(row-1, col-1).SetGridSymbol(this.players.get(1).getSymbol());
            if(this.colorornot){
                this.aGameBoard.GetContent(row-1, col-1).SetGridColor(this.players.get(1).getColor());
            }
        }
    }

    public void Generation(){
        for(int i=0; i<this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                this.aGameBoard.GetContent(i, j).SetTempstatus(this.aGameBoard.GetContent(i, j).getGridStatus());
            }
        }
        for(int i=0; i<this.rows; i++){
            for(int j=0; j<this.cols; j++){
                if(this.aGameBoard.GetContent(i, j).getGridStatus() == GridStatus.DEAD){
                    int count1 = 0;
                    int count2 = 0;
                    for(int k=i-1; k<=i+1; k++){
                        for(int m=j-1; m<=j+1; m++){
                            if(k>=0 && k<this.rows && m>=0 && m<this.cols){
                                if(this.aGameBoard.GetContent(k, m).getGridStatus() == GridStatus.ALIVE_1){
                                    count1++;
                                }
                                if(this.aGameBoard.GetContent(k, m).getGridStatus() == GridStatus.ALIVE_2){
                                    count2++;
                                }
                            }
                        }
                    }
                    if((count1 + count2) == 3 && count1>=2){
                        this.aGameBoard.GetContent(i, j).SetTempstatus(GridStatus.ALIVE_1);
                        this.aGameBoard.GetContent(i, j).SetGridSymbol(this.players.get(0).getSymbol());
                        if(this.colorornot){
                            this.aGameBoard.GetContent(i, j).SetGridColor(this.players.get(0).getColor());
                        }
                    }
                    if((count1 + count2) == 3 && count2>=2){
                        this.aGameBoard.GetContent(i, j).SetTempstatus(GridStatus.ALIVE_2);
                        this.aGameBoard.GetContent(i, j).SetGridSymbol(this.players.get(1).getSymbol());
                        if(this.colorornot){
                            this.aGameBoard.GetContent(i, j).SetGridColor(this.players.get(1).getColor());
                        }
                    }
                }

                if(this.aGameBoard.GetContent(i, j).getGridStatus() != GridStatus.DEAD){
                    int count = 0;
                    for(int k=i-1; k<=i+1; k++){
                        for(int m=j-1; m<=j+1; m++){
                            if(k>=0 && k<this.rows && m>=0 && m<this.cols) {
                                // The cell itself is counted but it's alive.
                                if (this.aGameBoard.GetContent(k, m).getGridStatus() == GridStatus.DEAD) {
                                    count++;
                                }
                            }
                        }
                    }
                    if(count <= 4 || count >= 7){
                        this.aGameBoard.GetContent(i, j).SetTempstatus(GridStatus.DEAD);
                        this.aGameBoard.GetContent(i, j).SetGridSymbol(" ");
                    }
                }
            }
        }
        for(int i=0; i<this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                this.aGameBoard.GetContent(i, j).SetGridStatus(this.aGameBoard.GetContent(i, j).getTempstatus());
            }
        }
    }
}
