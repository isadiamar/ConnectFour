package es.upm.miw.iwvg_devops.connectFour.models;

import es.upm.miw.iwvg_devops.connectFour.types.Color;

public class Turn {

    public static final int NUMBER_PLAYERS = 2;
    private final Board board;
    private final Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    private void reset() {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    void next() {
        if (!this.board.isTicTacToe(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }


}
