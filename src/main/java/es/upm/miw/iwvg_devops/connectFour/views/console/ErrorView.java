package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.types.Error;

public  class ErrorView extends es.upm.miw.iwvg_devops.connectFour.views.ErrorView {
    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            System.out.println(es.upm.miw.iwvg_devops.connectFour.views.ErrorView.Messages[error.ordinal()]);
        }
    }
}




