/*
 * Gihal Mapalagama
 * Task2 : Tic-Tac-Toe
 */
package task2;

import task2.Cell.Mark;

/**
 *
 * @author gihal
 */
public class Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cell[][] board = getFirstBoard();
        System.out.println("=======FIRST BOARD=======");
        printBoard(board);
        System.out.println("Winer : " + getTheWiner(board));

        board = getSecondBoard();
        System.out.println("=======SECOND BOARD=======");
        printBoard(board);
        System.out.println("Winer : " + getTheWiner(board));

        board = getThirdBoard();
        System.out.println("=======THITD BOARD=======");
        printBoard(board);
        System.out.println("Winer : " + getTheWiner(board));

        board = getFourthBoard();
        System.out.println("=======FOURTH BOARD=======");
        printBoard(board);
        System.out.println("Winer : " + getTheWiner(board));
    }

    public static void printBoard(Cell[][] board) {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                System.out.print(cell.mark + " ");
            }
            System.out.println("");
        }
    }

    public static Mark getTheWiner(Cell[][] board) {
        Mark checkRowsForWin = checkRowsForWin(board);
        if (checkRowsForWin != Mark.E) {
            return checkRowsForWin;
        }
        Mark checkColumnsForWin = checkColumnsForWin(board);
        if (checkColumnsForWin != Mark.E) {
            return checkColumnsForWin;
        }
        Mark checkDiagonalsForWin = checkDiagonalsForWin(board);
        if (checkDiagonalsForWin != Mark.E) {
            return checkDiagonalsForWin;
        }
        return Mark.E;
    }

    private static Mark checkRowsForWin(Cell[][] board) {
        for (int i = 0; i < 3; i++) {
            Mark mark = checkRowCol(board[i][0].mark, board[i][1].mark, board[i][2].mark);
            if (mark != Mark.E) {
                return mark;
            }
        }
        return Mark.E;
    }

    private static Mark checkColumnsForWin(Cell[][] board) {
        for (int i = 0; i < 3; i++) {
            Mark mark = checkRowCol(board[0][i].mark, board[1][i].mark, board[2][i].mark);
            if (mark != Mark.E) {
                return mark;
            }
        }
        return Mark.E;
    }

    private static Mark checkDiagonalsForWin(Cell[][] board) {
        Mark m1 = checkRowCol(board[0][0].mark, board[1][1].mark, board[2][2].mark);
        Mark m2 = checkRowCol(board[0][2].mark, board[1][1].mark, board[2][0].mark);
        if (m1 != Mark.E) {
            return m1;
        }
        if (m2 != Mark.E) {
            return m2;
        }
        return Mark.E;
    }

    private static Mark checkRowCol(Mark m1, Mark m2, Mark m3) {
        if ((m1 != Mark.E) && (m1 == m2) && (m2 == m3)) {
            return m1;
        } else {
            return Mark.E;
        }
    }

    /**
     * Test functions
     */
    public static Cell[][] getFirstBoard() {
        Cell[][] board = new Cell[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell(Cell.Mark.E);
            }
        }
        return board;
    }

    public static Cell[][] getSecondBoard() {
        Cell[][] board = new Cell[3][3];
        board[0][0] = new Cell(Mark.X);
        board[0][1] = new Cell(Mark.E);
        board[0][2] = new Cell(Mark.O);

        board[1][0] = new Cell(Mark.X);
        board[1][1] = new Cell(Mark.E);
        board[1][2] = new Cell(Mark.E);

        board[2][0] = new Cell(Mark.X);
        board[2][1] = new Cell(Mark.E);
        board[2][2] = new Cell(Mark.O);
        return board;
    }

    public static Cell[][] getThirdBoard() {
        Cell[][] board = new Cell[3][3];
        board[0][0] = new Cell(Mark.E);
        board[0][1] = new Cell(Mark.X);
        board[0][2] = new Cell(Mark.E);

        board[1][0] = new Cell(Mark.O);
        board[1][1] = new Cell(Mark.O);
        board[1][2] = new Cell(Mark.O);

        board[2][0] = new Cell(Mark.X);
        board[2][1] = new Cell(Mark.E);
        board[2][2] = new Cell(Mark.X);
        return board;
    }

    public static Cell[][] getFourthBoard() {
        Cell[][] board = new Cell[3][3];
        board[0][0] = new Cell(Mark.X);
        board[0][1] = new Cell(Mark.E);
        board[0][2] = new Cell(Mark.O);

        board[1][0] = new Cell(Mark.X);
        board[1][1] = new Cell(Mark.X);
        board[1][2] = new Cell(Mark.E);

        board[2][0] = new Cell(Mark.O);
        board[2][1] = new Cell(Mark.X);
        board[2][2] = new Cell(Mark.O);
        return board;
    }
}

class Cell {

    enum Mark {
        X("x"), O("o"), E("n");
        private String name;

        private Mark(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    };
    Mark mark;

    public Cell(Mark mark) {
        this.mark = mark;
    }

}
