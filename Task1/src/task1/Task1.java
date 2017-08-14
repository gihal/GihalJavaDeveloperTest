/*
 * Gihal Mapalagama.
 * Task1 : Java prgramme for the game of life is a cellular automaton devised by mathematician John Conway
 */
package task1;

/**
 *
 * @author gihal
 */
public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cell[][] board = getInitialBoard();
        System.out.println("=============INITIAL BOARD================");
        /**
         * Print initial board
         */
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.live) {
                    System.out.print("# ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        
        System.out.println("=============NEXT GENERATION================");
        board = getNextGeneration(board);        
        /**
         * Print the next generation
         */
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.live) {
                    System.out.print("# ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static Cell[][] getNextGeneration(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            Cell[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                int coutLiveCells = 0;
                
                if (isLive(board, i - 1, j - 1)) { //left top
                    coutLiveCells++;
                }
                
                if (isLive(board, i - 1, j)) { //top
                    coutLiveCells++;
                }
                
                if (isLive(board, i - 1, j + 1)) { //right top
                    coutLiveCells++;
                }
                
                if (isLive(board, i, j + 1)) { //right
                    coutLiveCells++;
                }
                
                if (isLive(board, i + 1, j + 1)) { //bottom right
                    coutLiveCells++;
                }
                
                if (isLive(board, i + 1, j)) { //bottom
                    coutLiveCells++;
                }
               
                if (isLive(board, i + 1, j - 1)) { //bottom left
                    coutLiveCells++;
                }
                
                if (isLive(board, i, j - 1)) { //left
                    coutLiveCells++;
                }
                
                Cell cell = board[i][j];
                if (coutLiveCells < 2) {
                    cell.nxtState = 0;
                } else if (cell.live && coutLiveCells >= 2 && coutLiveCells <= 3) {
                    cell.nxtState = 1;
                } else if (!cell.live && coutLiveCells == 3) {
                    cell.nxtState = 1;
                } else if (coutLiveCells > 3) {
                    cell.nxtState = 0;
                }
            }

        }

        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.nxtState == 1) {
                    cell.live = true;
                } else {
                    cell.live = false;
                }
                cell.nxtState = -1;
            }
        }
        return board;
    }

    public static boolean isLive(Cell[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1) {
            return false;
        }
        if (j < 0 || j > board[i].length - 1) {
            return false;
        }
        return board[i][j].live;
    }

    public static Cell[][] getInitialBoard() {
        Cell[][] board = new Cell[6][3];
        for (int i = 0; i < board.length; i++) {
            boolean live = false;
            if (i == 2 || i == 3) {
                live = true;
            }
            board[i][0] = new Cell(live);
            board[i][1] = new Cell(live);
            board[i][2] = new Cell(live);
        }
        return board;
    }

}

class Cell {

    boolean live;
    /**
     * nxtState = -1 doesn't know the next state. nxtState = 0 will become a
     * dead cell in next generation nxtState = 1 will become live in next
     * generation
     */
    int nxtState;

    public Cell(boolean live) {
        this.live = live;
        this.nxtState = -1;
    }
}
