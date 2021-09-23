package es.upm.miw.iwvg_devops.connectFour;

public class ConnectFour {
    private final Board board;
    private final Turn turn;

    ConnectFour() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public static void main(String[] args) {
        new ConnectFour().play();
    }

    private void play() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isConnectFour());
        this.turn.writeWinner();
    }

    private boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }
}
