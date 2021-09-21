package es.upm.miw.iwvg_devops.connectFour;

public class Board {
    private final static int COLUMN_SIZE = 7;
    private final static int ROW_SIZE = 6;
    private final static char FREE_POSITION = ' ';

    private final char[][] grid;

    public Board() {
        this.grid = initializeGrid();
    }

    public void display() {
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("---------------");
        for (char[] chars : grid) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(chars[col]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------------");
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println();
    }

    public void addToken(int column, char token) throws Exception {
        //assert column >= 1 && column <=7 && this.grid[0][column] == FREE_POSITION;
        if ((column < 0 || column > ROW_SIZE) || (this.grid[0][column] != FREE_POSITION)) {
            throw new Exception("Column not valid");
        }

        for (int row = ROW_SIZE - 1; row >= 0; row--) {
            if (this.grid[row][column] == FREE_POSITION) {
                this.grid[row][column] = token;
                break;
            }
        }
    }


    // Clase coordenada responsable de este metodo (el metodo reestructurado) - Decirle direcciones!
    public boolean hasWinner(char activePlayerToken) {
        //check for 4 across
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[0].length - 3; col++) {
                if (this.grid[row][col] == activePlayerToken &&
                        this.grid[row][col + 1] == activePlayerToken &&
                        this.grid[row][col + 2] == activePlayerToken &&
                        this.grid[row][col + 3] == activePlayerToken) {
                    return true;
                }
            }
        }
        //check for 4 up and down
        for (int row = 0; row < this.grid.length - 3; row++) {
            for (int col = 0; col < this.grid[0].length; col++) {
                if (this.grid[row][col] == activePlayerToken &&
                        this.grid[row + 1][col] == activePlayerToken &&
                        this.grid[row + 2][col] == activePlayerToken &&
                        this.grid[row + 3][col] == activePlayerToken) {
                    return true;
                }
            }
        }
        //check diagonal
        for (int row = 3; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[0].length - 3; col++) {
                if (this.grid[row][col] == activePlayerToken &&
                        this.grid[row - 1][col + 1] == activePlayerToken &&
                        this.grid[row - 2][col + 2] == activePlayerToken &&
                        this.grid[row - 3][col + 3] == activePlayerToken) {
                    return true;
                }
            }
        }
        //check inverse diagonal
        for (int row = 0; row < this.grid.length - 3; row++) {
            for (int col = 0; col < this.grid[0].length - 3; col++) {
                if (this.grid[row][col] == activePlayerToken &&
                        this.grid[row + 1][col + 1] == activePlayerToken &&
                        this.grid[row + 2][col + 2] == activePlayerToken &&
                        this.grid[row + 3][col + 3] == activePlayerToken) {
                    return true;
                }
            }
        }
        return false;
    }

    private char[][] initializeGrid() {
        char[][] res = new char[ROW_SIZE][COLUMN_SIZE];
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                res[row][col] = FREE_POSITION;
            }
        }
        return res;
    }
}
