import java.util.Scanner;

public class GameControl {

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
        while (playerSymbol.length() < 1 || playerSymbol.length() > 2) {
            System.out.print("Please type in some name: ");
            playerSymbol = scanner.nextLine();
        }

        return playerSymbol;
    }

}
