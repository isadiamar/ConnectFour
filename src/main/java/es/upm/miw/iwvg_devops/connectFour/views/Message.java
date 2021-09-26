package es.upm.miw.iwvg_devops.connectFour.views;

public enum Message {

    TITLE("--- TIC TAC TOE ---"),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("Player #player, enter a column to put a token:"),
    RESUME("Do you want to continue"),
    FULL_BOARD("The board is full, anybody has won."),
    PLAYER_WIN("#player player: You win!!! :-)");


    private final String message;

    Message(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return message;
    }
}
