package es.upm.miw.iwvg_devops.connectFour.utils;

public enum Direction {
    VERTICAL(1, 0),
    HORIZONTAL(0, 1),
    MAIN_DIAGONAL(-1, 1),
    INVERSE_DIAGONAL(1, 1),
    NULL(0, 0);

    int shift_row;
    int shift_column;

    Direction(int row, int column) {
        this.shift_row = row;
        this.shift_column = column;
    }

    public int getRow() {
        return this.shift_row;
    }

    public int getColumn() {
        return this.shift_column;
    }

    public boolean isNull() {
        return this == Direction.NULL;
    }

}
