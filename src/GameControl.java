import java.util.Scanner;

public class GameControl {
    private int rows;
    private int cols;
    private static int[][] grid;

    public void setUpBoard() {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the grid
        System.out.print("Enter the number of rows(numbers between 10-40): ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of columns(numbers between 10-40): ");
        cols = scanner.nextInt();

        // Create the grid
        grid = new int[rows][cols];
    }

    public String getPlayerNameAndSymbol(int PlayerNr) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player " + PlayerNr+ ":, please input your name: ");
        String playerName = scanner.nextLine();
        while (playerName.length() < 1) {
            System.out.print("Please type in some name: ");
            playerName = scanner.nextLine();
        }

        return playerName;
    }

    public String getPlayerSymbol(int PlayerNr){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player "+PlayerNr+ "please input a single capital letter from A-Z as your symbol: ");
        String playerSymbol = scanner.nextLine();

        return playerSymbol;
    }

}
