package views;

import utils.ColorUtils;

public class GameView {

    ColorUtils colorUtils = new ColorUtils();

    public GameView() {
    }

    public void showBlueMessage(String message) {
        String coloredMessage = ColorUtils.colorTextWithBackground(ColorUtils.ANSI_BLACK, ColorUtils.ANSI_CYAN_BACKGROUND, message);
        System.out.println("\n" + coloredMessage);
    }

    public void showPurpleMessage(String message) {
        String coloredMessage = ColorUtils.colorTextWithBackground(ColorUtils.ANSI_BLACK, ColorUtils.ANSI_PURPLE_BACKGROUND, message);
        System.out.println("\n" + coloredMessage);
    }

    public void showError(String error) {
        String coloredMessage = ColorUtils.colorText(ColorUtils.ANSI_RED, "ERROR: " + error);
        System.out.println("\n" + coloredMessage);
    }

    public void displayBoard(String[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String cell = ColorUtils.colorTextWithBackground(ColorUtils.ANSI_BLACK, ColorUtils.ANSI_BLUE_BACKGROUND, board[i][j] + " ");
                System.out.print(cell);
            }
            System.out.println();
        }
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

    public void showStartMessage() throws InterruptedException {
        String startMessage = ColorUtils.colorTextWithBackground(ColorUtils.ANSI_BLACK, ColorUtils.ANSI_RED_BACKGROUND, "Empieza la partida...");
        System.out.println("\n" + startMessage);
        Thread.sleep(1000);
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
}
