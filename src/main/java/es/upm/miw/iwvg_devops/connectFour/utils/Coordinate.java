package es.upm.miw.iwvg_devops.connectFour.utils;

public interface Coordinate {
    Coordinate NULL = NullCoordinate.getInstance();

    boolean isNull();

    Direction getDirection(Coordinate coordinate);

    boolean inHorizontal(Coordinate coordinate);

    boolean inVertical(Coordinate coordinate);

    boolean inMainDiagonal();

}
