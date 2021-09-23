package es.upm.miw.iwvg_devops.connectFour.utils;

public enum Direction {
    VERTICAL,
    HORIZONTAL,
    MAIN_DIAGONAL,
    INVERSE_DIAGONAL,
    NULL;

    public boolean isNull() {
        return this == Direction.NULL;
    }

}
