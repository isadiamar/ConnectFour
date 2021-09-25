package es.upm.miw.iwvg_devops.connectFour;

import es.upm.miw.iwvg_devops.connectFour.utils.SquareBoundedCoordinate;

public class Coordinate extends SquareBoundedCoordinate {
    public static final int ROW_SIZE = 6;
    public static final int COLUMN_SIZE = 7;


    Coordinate() {
        super();
    }

    Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    protected int getDimension() {
        return Coordinate.ROW_SIZE * Coordinate.COLUMN_SIZE;
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
            return this.getColumn() == other.getColumn();
        }
        return true;
    }

}
