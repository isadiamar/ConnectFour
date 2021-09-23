package es.upm.miw.iwvg_devops.connectFour;

public enum Error {
    NOT_EMPTY("The square is not empty"),
    COLUMN_NOT_VALID("The column is not valid"),
    NOT_OWNER("There is not a token of yours"),
    SAME_COORDINATES("The origin and target squares are the same"),
    WRONG_COORDINATES("The coordinates are wrong"),
    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    void writeln() {
        if (!this.isNull()) {
            System.out.println(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}
