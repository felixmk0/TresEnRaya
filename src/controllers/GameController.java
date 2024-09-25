package controllers;

import models.Board;
import models.Player;
import utils.MathUtils;
import views.GameView;

import java.util.Random;

public class GameController {
    private Board board;

    private Player player1;
    private Player player2;

    private final MathUtils mathUtils = new MathUtils();

    private GameView view;

    public GameController() {
    }

    public GameController(Board board, Player player1, Player player2, GameView view) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
    }

    // HORIZONTALMENTE
    public boolean checkHorizontally(Board board, Player p, int col) {
        boolean threeInARow = false;
        if (board.getBoard()[col][0].equals(p.getFigure()) && board.getBoard()[col][0].equals(board.getBoard()[col][1]) && board.getBoard()[col][1].equals(board.getBoard()[col][2])) {
            threeInARow = true;
            view.showBlueMessage("WINNER " + p.getName());
            p.setPoints(p.getPoints() + 1);
        }

        return threeInARow;
    }

    // VERTICALMENTE
    public boolean checkVertically(Board board, Player p, int row) {
        boolean threeInARow = false;
        if (board.getBoard()[0][row].equals(p.getFigure()) && board.getBoard()[0][row].equals(board.getBoard()[1][row]) && board.getBoard()[1][row].equals(board.getBoard()[2][row])) {
            threeInARow = true;
            view.showBlueMessage("WINNER " + p.getName());
            p.setPoints(p.getPoints() + 1);
        }

        return threeInARow;
    }

    // ESCOJER QUE JUGADOR EMPIEZA
    public void chooseStartPlayer(Player p1, Player p2) {
        Random random = new Random();
        int index = random.nextInt(2);
        view.showBlueMessage("Escojiendo aleatoriamente quien empeiza...");
        if (index == 0) view.showBlueMessage("Has tenigo suerte " + p1.getName() + ", empiezas tu!");
        else view.showBlueMessage("Has tenigo suerte " + p2.getName() + ", empiezas tu!");
    }

    // OBTENER COORDENADA DE LA CONSOLA (EJ: 1, 0); FILA 1 en COLUMNA 0
    public void insertCoordinate(String pos, Player p) {

        pos = pos.replace(" ", "");
        int row = 0, col = 0;

        if (pos.charAt(1) == ',' && pos.length() == 3 && mathUtils.charToInt(pos.charAt(0)) <= 3 && mathUtils.charToInt(pos.charAt(2)) <= 3) {
            row = mathUtils.charToInt(pos.charAt(0));
            col = mathUtils.charToInt(pos.charAt(2));

            board.insertBoard(row, col, p);
            view.displayBoard(board.getBoard());
        } else {
            view.showError("Debes utilizar el formato solicitado (FILA, COLUMNA)!");
        }

    }
}
