package es.upm.miw.iwvg_devops.connectFour;

enum Message {

    TITLE("--- TIC TAC TOE ---"),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("Player #player, enter a column to put a token:"),
    COORDINATE_TO_PUT("Coordinate to put"),
    PLAYER_WIN("#player player: You win!!! :-)");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    void write() {
        System.out.print(this.message);
    }

    void writeln() {
        System.out.println(this.message);
    }

    void writeln(String player) {
        assert this == Message.PLAYER_WIN;

        System.out.println(this.message.replaceAll("#player", "" + player));
    }

    @Override
    public String toString() {
        return message;
    }
}
