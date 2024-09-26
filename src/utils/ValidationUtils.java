package utils;

import models.Board;
import models.Player;

public class ValidationUtils {

    MathUtils mathUtils = new MathUtils();

    public ValidationUtils() {
    }

    public boolean validateInput(String position) {
        position = position.replace(" ", "");
        return position.charAt(1) == ',' && position.length() == 3 && mathUtils.charToInt(position.charAt(0)) <= 3 && mathUtils.charToInt(position.charAt(2)) <= 3;
    }

    public boolean checkVertically(Board board, Player p, int col) {
        return board.getBoard()[col][0].equals(p.getFigure()) && board.getBoard()[col][0].equals(board.getBoard()[col][1]) && board.getBoard()[col][1].equals(board.getBoard()[col][2]);
    }

    public boolean checkHorizontally(Board board, Player p, int row) {
        return board.getBoard()[0][row].equals(p.getFigure()) && board.getBoard()[0][row].equals(board.getBoard()[1][row]) && board.getBoard()[1][row].equals(board.getBoard()[2][row]);
    }

    public boolean checkDiagonally(Board board, Player p) {
        return board.getBoard()[0][0].equals(p.getFigure()) && board.getBoard()[0][0].equals(board.getBoard()[1][1]) && board.getBoard()[1][1].equals(board.getBoard()[2][2]) || board.getBoard()[0][2].equals(p.getFigure()) && board.getBoard()[0][2].equals(board.getBoard()[1][1]) && board.getBoard()[1][1].equals(board.getBoard()[2][0]);
    }

    public boolean checkPosition(Board board, int col, int row) {
        return board.getBoard()[col][row].equals("?");
    }

    public boolean figureLenght(String fig) {
        return fig.length() > 1;
    }
}