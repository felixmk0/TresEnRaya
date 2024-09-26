import controllers.GameController;
import models.Board;
import models.Player;
import views.GameView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameView view = new GameView();

        Player player1 = new Player();
        Player player2 = new Player();

        Board board = new Board();

        GameController controller = new GameController(board, player1, player2, view);

        Scanner scanner = new Scanner(System.in);

        //==============================================================================

        view.welcomeMessage();
        view.showTutorial();

        controller.gameSetup(player1);
        controller.gameSetup(player2);

        view.showPurpleMessage("Preparense que empezamos...");
        Thread.sleep(1000);

        controller.chooseStartPlayer(player1, player2);

        do {
            view.showCurrentPlayerTurn(player1, player2);
            controller.insertFigure(scanner.nextLine(), player1, player2);
        } while (player1.getPoints() <= 0 && player2.getPoints() <= 0);
    }
}