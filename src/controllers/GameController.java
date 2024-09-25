package controllers;

import models.Board;
import models.Player;
import utils.MathUtils;
import utils.ValidationUtils;
import views.GameView;

import java.util.Arrays;
import java.util.Random;

public class GameController {
    private Board board;

    private Player player1;
    private Player player2;

    private GameView view;

    ValidationUtils validationUtils = new ValidationUtils();
    MathUtils mathUtils = new MathUtils();

    public GameController() {
    }

    public GameController(Board board, Player player1, Player player2, GameView view) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
    }


    public void chooseStartPlayer(Player p1, Player p2) {
        Random random = new Random();
        int index = random.nextInt(2);
        view.showBlueMessage("Escogiendo aleatoriamente quien empeiza...");
        if (index == 0) {
            view.showBlueMessage("Has tenigo suerte " + p1.getName() + ", empiezas tu!");
            p1.setTurn(true);
        } else {
            view.showBlueMessage("Has tenigo suerte " + p2.getName() + ", empiezas tu!");
            p2.setTurn(true);
        }
    }

    public boolean checkHorizontally(Player p, int col) {
        if (board.getBoard()[col][0].equals(p.getFigure()) && board.getBoard()[col][0].equals(board.getBoard()[col][1]) && board.getBoard()[col][1].equals(board.getBoard()[col][2])) {
            view.showBlueMessage("WINNER " + p.getName());
            p.setPoints(p.getPoints() + 1);
            return true;
        }
        return false;
    }

    public boolean checkVertically(Player p, int row) {
        if (board.getBoard()[0][row].equals(p.getFigure()) && board.getBoard()[0][row].equals(board.getBoard()[1][row]) && board.getBoard()[1][row].equals(board.getBoard()[2][row])) {
            view.showBlueMessage("WINNER " + p.getName());
            p.setPoints(p.getPoints() + 1);
            return true;
        }
        return false;
    }

    public void insertFigure(String pos, Player p1, Player p2) {
        pos = pos.replace(" ", "");

        if (validationUtils.validatePosition(pos)) {
            int row = mathUtils.charToInt(pos.charAt(0));
            int col = mathUtils.charToInt(pos.charAt(2));

            if (checkVertically(getCurrentPlayer(p1, p2), row)) {
                getCurrentPlayer(p1, p2).setPoints(getCurrentPlayer(p1, p2).getPoints() + 1);
            }

            if (checkHorizontally(getCurrentPlayer(p1, p2), col)) {
                getCurrentPlayer(p1, p2).setPoints(getCurrentPlayer(p1, p2).getPoints() + 1);
            }

            board.insertBoard(row, col, setCurrentPlayer(p1, p2));
            view.displayBoard(board.getBoard());
        } else {
            view.showError("Debes utilizar el formato solicitado (FILA, COLUMNA)!");
        }
    }

    public Player setCurrentPlayer(Player p1, Player p2) {
        if (p1.isTurn()) {
            p1.setTurn(false);
            p2.setTurn(true);
            return p1;
        } else if (p2.isTurn()) {
            p2.setTurn(false);
            p1.setTurn(true);
            return p2;
        }
        return null;
    }

    public Player getCurrentPlayer(Player p1, Player p2) {
        if (p1.isTurn()) return p1;
        else if (p2.isTurn()) return p2;

        return null;
    }
}
