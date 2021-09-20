package es.upm.miw.iwvg_devops.connectFour.types;

public enum Color {
    X,
    O,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();
        return Color.values()[ordinal];
    }


    boolean isNull() {
        return this == Color.NULL;
    }

}