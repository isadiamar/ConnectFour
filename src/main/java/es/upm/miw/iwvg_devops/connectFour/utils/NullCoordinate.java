package es.upm.miw.iwvg_devops.connectFour.utils;

public class NullCoordinate implements Coordinate {
    private static NullCoordinate instance;

    private NullCoordinate() {
    }

    static Coordinate getInstance() {
        if (NullCoordinate.instance == null) {
            NullCoordinate.instance = new NullCoordinate();
        }
        return NullCoordinate.instance;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public Direction getDirection(Coordinate coordinate) {
        return Direction.NULL;
    }

    @Override
    public boolean inHorizontal(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean inVertical(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean inMainDiagonal() {
        return false;
    }

    @Override
    public String toString() {
        return "Coordinate (NULL)";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
