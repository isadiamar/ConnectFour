package es.upm.miw.iwvg_devops.connectFour;

import es.upm.miw.iwvg_devops.connectFour.models.Game;
import es.upm.miw.iwvg_devops.connectFour.views.console.ConsoleView;

public class ConsoleConnectFour extends ConnectFour {

    @Override
    protected ConsoleView createView(Game game) {
        return new ConsoleView(game);
    }
    public static void main(String[] args) {
        new ConsoleConnectFour().play();
    }
}
