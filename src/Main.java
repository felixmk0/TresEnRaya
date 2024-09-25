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

        view.showBlueMessage("JUGADOR 1: Introduce tu nombre:");
        player1.setName(scanner.nextLine().toUpperCase());

        view.showBlueMessage(player1.getName() + ", introduce tu figura:");
        player1.setFigure(scanner.nextLine().toUpperCase());

        view.showBlueMessage("JUGADOR 2: Introduce tu nombre:");
        player2.setName(scanner.nextLine().toUpperCase());

        view.showBlueMessage(player2.getName() + ", introduce tu figura:");
        player2.setFigure(scanner.nextLine().toUpperCase());

        view.showStartMessage();

        controller.chooseStartPlayer(player1, player2);

        view.showPurpleMessage("Introduce una coordenada: ");
        controller.insertCoordinate(scanner.nextLine(), player1);
    }
}