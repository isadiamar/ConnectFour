package es.upm.miw.iwvg_devops.connectFour.utils;

import java.util.Scanner;

public class YesNoDialog {
    private static final char AFFIRMATIVE = 'y';
    private static final char NEGATIVE = 'n';
    private static final String SUFFIX = "? (" +
            YesNoDialog.AFFIRMATIVE + "/" +
            YesNoDialog.NEGATIVE + "): ";
    private static final String MESSAGE = "The value must be '" +
            YesNoDialog.AFFIRMATIVE + "' or '" +
            YesNoDialog.NEGATIVE + "'";


    public void read(String message) {
        assert message != null;
        boolean ok;

        do {
            System.out.print(message + YesNoDialog.SUFFIX);
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                System.out.println(YesNoDialog.MESSAGE);
            }
        } while (!ok);

    }

    public boolean isAffirmative() {
        return this.getAnswer() == YesNoDialog.AFFIRMATIVE;
    }

    public boolean isNegative() {
        return this.getAnswer() == YesNoDialog.NEGATIVE;
    }

    private char getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.next().charAt(0);
    }
}
