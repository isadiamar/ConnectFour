package es.upm.miw.iwvg_devops.connectFour.models;

import es.upm.miw.iwvg_devops.connectFour.types.Color;
import es.upm.miw.iwvg_devops.connectFour.types.Coordinate;

public class Player {

    private final Color color;
    private final Board board;
    private final int putTokens;


    public Player(Color color, Board board) {
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    void putToken(int column) {
        assert this.putTokens < Coordinate.COLUMN_SIZE;

        //this.colors[coordinate.getRow()][coordinate.getColumn()] = color;

    }
    
    public Color getColor() {
        return this.color;
    }
}
