package es.upm.miw.iwvg_devops.connectFour.models;

import es.upm.miw.iwvg_devops.connectFour.types.Color;
import es.upm.miw.iwvg_devops.connectFour.types.Coordinate;

public class Player {

    private final Color color;
    private final Board board;
    int MAX_TOKENS = (Coordinate.ROW_SIZE * Coordinate.COLUMN_SIZE)/2;
    private int putTokens;

    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    public boolean areAllTokensOnBoard() {
        return this.putTokens == MAX_TOKENS;
    }

    void putToken(int column) {
        assert this.putTokens < MAX_TOKENS;
        this.board.putToken(column, this.color);
        this.putTokens++;
    }

    public Color getColor() {
        return this.color;
    }


}
