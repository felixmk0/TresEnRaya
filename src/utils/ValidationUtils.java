package utils;

import models.Board;
import models.Player;

public class ValidationUtils {

    MathUtils mathUtils = new MathUtils();

    public ValidationUtils() {
    }

    public boolean validatePosition(String position) {
        position = position.replace(" ", "");
        return position.charAt(1) == ',' && position.length() == 3 && mathUtils.charToInt(position.charAt(0)) <= 3 && mathUtils.charToInt(position.charAt(2)) <= 3;
    }

    public boolean checkHorizontally(Board board, Player p, int col) {
        return board.getBoard()[col][0].equals(p.getFigure()) && board.getBoard()[col][0].equals(board.getBoard()[col][1]) && board.getBoard()[col][1].equals(board.getBoard()[col][2]);
    }

    public boolean checkVertically(Board board, Player p, int row) {
        return board.getBoard()[0][row].equals(p.getFigure()) && board.getBoard()[0][row].equals(board.getBoard()[1][row]) && board.getBoard()[1][row].equals(board.getBoard()[2][row]);
    }



}
