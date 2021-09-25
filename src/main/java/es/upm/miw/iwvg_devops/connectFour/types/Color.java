package es.upm.miw.iwvg_devops.connectFour.types;

public enum Color {
    X,
    O,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public void write() {
        String string = this.name();
        if (this.isNull()) {
            string = " ";
        }
        System.out.print(string);
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
}
