package model;

import exceptions.InvalidSize;

public class Grid {

    public Grid(int rows, int cols) throws InvalidSize {
        if (rows < 10 || rows > 100 || cols < 10 || cols > 100){
            throw new InvalidSize();
        }
        System.out.println(rows + "," + cols);
    }
}
