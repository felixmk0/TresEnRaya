package controllers;

import models.Board;
import models.Player;
import utils.MathUtils;
import utils.ValidationUtils;
import views.GameView;

import java.util.Random;
import java.util.Scanner;

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
            view.showBlueMessage("Has tenido suerte " + p1.getName() + ", empiezas tu!");

            view.displayBoard(board.getBoard());
            p1.setTurn(true);
        } else {
            view.showBlueMessage("Has tenido suerte " + p2.getName() + ", empiezas tu!");

            view.displayBoard(board.getBoard());
            p2.setTurn(true);
        }
    }

    public void insertFigure(String pos, Player p1, Player p2) {
        pos = pos.replace(" ", "");

        if (validationUtils.validateInput(pos)) {
            int row = mathUtils.charToInt(pos.charAt(0));
            int col = mathUtils.charToInt(pos.charAt(2));

            if (validationUtils.checkPosition(board, row, col)) {
                board.insertBoard(row, col, getCurrentPlayer(p1, p2));

                if (validationUtils.checkVertically(board, getCurrentPlayer(p1, p2), row) || validationUtils.checkHorizontally(board, getCurrentPlayer(p1, p2), col) || validationUtils.checkDiagonally(board, getCurrentPlayer(p1, p2))) {
                    getCurrentPlayer(p1, p2).setPoints(1);
                    view.showWinMessage(getCurrentPlayer(p1, p2));
                }

                setCurrentPlayer(p1, p2);
                view.displayBoard(board.getBoard());
            } else {
                view.showError("Esa posición ya esta ocupada! \nVuelve a tirar porfavor.");
                view.displayBoard(board.getBoard());
            }
        } else {
            view.showError("Debes utilizar el formato solicitado (FILA, COLUMNA)!");
        }
    }

    public Player setCurrentPlayer(Player p1, Player p2) {
        if (p1.isTurn()) {
            p1.setTurn(false);
            p2.setTurn(true);
            return p1;
        } else {
            p2.setTurn(false);
            p1.setTurn(true);
            return p2;
        }
    }

    public Player getCurrentPlayer(Player p1, Player p2) {
        if (p1.isTurn()) return p1;
        else return p2;
    }

    public void gameSetup(Player p) {
        String pFigure = "";
        Scanner scanner = new Scanner(System.in);

        view.showBlueMessage("Introduce tu nombre:");
        p.setName(scanner.nextLine().toUpperCase());

        do {
            view.showBlueMessage("Introduce tu figura, " + p.getName() + ":");
            pFigure = scanner.nextLine().toUpperCase();
            p.setFigure(pFigure);

            if (validationUtils.figureLenght(pFigure)) view.showError("La figura debe de tener solo 1 carácter!");
        } while (validationUtils.figureLenght(pFigure));
    }
}
