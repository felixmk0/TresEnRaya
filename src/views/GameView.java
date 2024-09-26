package views;

import models.Player;
import utils.ColorUtils;

public class GameView {

    public GameView() {
    }

    public void showBlueMessage(String message) {
        System.out.println("\n" + ColorUtils.ANSI_BLUE_BACKGROUND + ColorUtils.ANSI_BLACK + message + ColorUtils.ANSI_RESET);
    }

    public void showPurpleMessage(String message) {
        System.out.println("\n" + ColorUtils.ANSI_PURPLE_BACKGROUND + ColorUtils.ANSI_BLACK + message + ColorUtils.ANSI_RESET);
    }

    public void showError(String error) {
        System.out.println("\n" + ColorUtils.ANSI_RED + "ERROR: " + error + ColorUtils.ANSI_RESET);
    }

    public void displayBoard(String[][] board) {
        System.out.println();
        System.out.println(ColorUtils.ANSI_RED_BACKGROUND + ColorUtils.ANSI_BLACK + "   0 1 2    " + ColorUtils.ANSI_RESET);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0)
                    System.out.print(ColorUtils.ANSI_RED_BACKGROUND + ColorUtils.ANSI_BLACK + " " + i + " " + ColorUtils.ANSI_RESET);
                System.out.print(ColorUtils.ANSI_BLUE_BACKGROUND + ColorUtils.ANSI_BLACK + board[i][j] + " ");

                if (j == board[i].length - 1)
                    System.out.print(ColorUtils.ANSI_RED_BACKGROUND + ColorUtils.ANSI_BLACK + " " + i + " " + ColorUtils.ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println(ColorUtils.ANSI_RED_BACKGROUND + ColorUtils.ANSI_BLACK + "   0 1 2    " + ColorUtils.ANSI_RESET);
    }

    public void showTutorial() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                   ¿CÓMO JUGAR?                       ║");
        System.out.println("║                                                      ║");
        System.out.println("║ Se debe introducir al pedir el jugador la coordenada ║");
        System.out.println("║ de la posición en la Matriz. Por ejemplo:            ║");
        System.out.println("║ De la fila 0, columna 3, debe introducir: '0, 3'     ║");
        System.out.println("║                                                      ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    public void welcomeMessage() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║       ★ ★ ★ BIENVENIDO A TRES EN RAYA ★ ★ ★        ║");
        System.out.println("║                                                      ║");
        System.out.println("║           Un clásico juego para 2 jugadores          ║");
        System.out.println("║                                                      ║");
        System.out.println("║                 Author: @felixmk0                    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    public void showCurrentPlayerTurn(Player p1, Player p2) {
        System.out.println();
        if (p1.isTurn())
            System.out.println(ColorUtils.ANSI_PURPLE_BACKGROUND + ColorUtils.ANSI_BLACK + "Introduce una coordenada, " + p1.getName() + " (" + p1.getFigure() + ")" + ":" + ColorUtils.ANSI_RESET);
        else if (p2.isTurn())
            System.out.println(ColorUtils.ANSI_PURPLE_BACKGROUND + ColorUtils.ANSI_BLACK + "Introduce una coordenada, " + p2.getName() + " (" + p2.getFigure() + ")" + ":" + ColorUtils.ANSI_RESET);
    }

    public void showWinMessage(Player p) {
        System.out.println("\n" + ColorUtils.ANSI_YELLOW_BACKGROUND + ColorUtils.ANSI_BLACK + "Has ganado, " + p.getName() + "!!" + " Resultado final:" + ColorUtils.ANSI_RESET);
    }
}
