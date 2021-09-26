package es.upm.miw.iwvg_devops.connectFour.views;
import es.upm.miw.iwvg_devops.connectFour.types.Error;
public abstract class ErrorView {
    public static final String[]Messages = {
            "The column is not valid"
    };
    public abstract void writeln(Error error);
}
