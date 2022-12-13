public class GameOfLife {
    // the current state of the game grid
    private boolean[][] grid;

    // the next state of the game grid
    private boolean[][] next;

    // the width and height of the game grid
    private int width, height;

    // constructor that initializes the game grid
    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[height][width];
        next = new boolean[height][width];
    }

    // method that updates the game state
    public void update() {
        // loop through each cell in the grid
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // count the number of living neighbors
                int neighbors = countNeighbors(x, y);

                // apply the rules of the game to determine
                // whether the cell should be alive or dead
                // in the next state
                if (grid[y][x] && (neighbors == 2 || neighbors == 3)) {
                    next[y][x] = true;
                } else if (!grid[y][x] && neighbors == 3) {
                    next[y][x] = true;
                } else {
                    next[y][x] = false;
                }
            }
        }

        // copy the next state into the current state
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = next[y][x];
            }
        }
    }

    // helper method that counts the number of living neighbors
    // for a given cell in the grid
    private int countNeighbors(int x, int y) {
        int count = 0;
        return count;
    }}


