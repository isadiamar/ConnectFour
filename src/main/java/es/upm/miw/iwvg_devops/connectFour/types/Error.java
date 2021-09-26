package es.upm.miw.iwvg_devops.connectFour.types;

public enum Error {
    COLUMN_NOT_VALID,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }
}
