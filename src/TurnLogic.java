public class TurnLogic {

    public void countNeighbors(){

    }

    // 别的地方看到的例子 仅供参考
    public void update() {
        // loop through each cell in the grid
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < column; x++) {
                // count the number of living neighbors
                int neighbors = countNeighbors(x, y);

                // apply the rules of the game to determine
                // whether the cell should be alive or dead
                // in the next state
                if (board[y][x] && (neighbors == 2 || neighbors == 3)) {
                    next[y][x] = true;
                } else if (!board[y][x] && neighbors == 3) {
                    next[y][x] = true;
                } else {
                    next[y][x] = false;
                }
            }
        }

        // copy the next state into the current state
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < column; x++) {
                board[y][x] = next[x][x];
            }
        }
    }
}
