package es.upm.miw.iwvg_devops.connectFour.models;

import es.upm.miw.iwvg_devops.connectFour.types.Color;
import es.upm.miw.iwvg_devops.connectFour.types.Coordinate;

public class Board {
    private final Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.ROW_SIZE][Coordinate.COLUMN_SIZE];
        this.reset();
    }

    private void reset() {

    }

    public boolean isTicTacToe(Color activeColor) {
        return false;
    }


}
