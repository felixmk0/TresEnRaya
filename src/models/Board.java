package models;

public class Board {
    public String[][] Board = {
            {"?", "?", "?"},
            {"?", "?", "?"},
            {"?", "?", "?"}
    };

    public Board() {
    }

    public String[][] getBoard() {
        return Board;
    }

    public void setBoard(String[][] board) {
        Board = board;
    }

    public void insertBoard(int row, int col, Player p) {
        Board[row][col] = p.getFigure();
    }
}
