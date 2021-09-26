package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.types.Color;

public class ColorView {
    void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        System.out.print(string);
    }
}
