package es.upm.miw.iwvg_devops.connectFour.models;

import es.upm.miw.iwvg_devops.connectFour.types.Color;
import es.upm.miw.iwvg_devops.connectFour.types.Coordinate;

public class Game {
    private final Board board;
    private final Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.generatePlayers();
    }

    public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return this.turn.areAllTokensOnBoard();
    }

    public void putToken(int column) {
        this.turn.putToken(column);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (!board.equals(other.board))
            return false;
        return turn.equals(other.turn);
    }

}
