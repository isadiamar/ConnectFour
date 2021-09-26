package es.upm.miw.iwvg_devops.connectFour.models;

import es.upm.miw.iwvg_devops.connectFour.types.Color;

public class Turn {
    static final int NUMBER_PLAYERS = 2;
    private final Board board;
    private final Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.generatePlayers();
    }

    void generatePlayers() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    void next() {
        if (!this.board.isConnectFour(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public Color getActiveColor() {
        return this.players[this.activePlayer].getColor();
    }

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    boolean areAllTokensOnBoard() {
        return this.getActivePlayer().areAllTokensOnBoard();
    }

    void putToken(int column) {
        this.getActivePlayer().putToken(column);
    }


}
