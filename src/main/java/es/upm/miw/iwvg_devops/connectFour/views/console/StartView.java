package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.models.Game;
import es.upm.miw.iwvg_devops.connectFour.views.Message;
import es.upm.miw.iwvg_devops.connectFour.views.WithGameView;

public class StartView extends WithGameView {
    StartView(Game game) {
        super(game);
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.game);
    }
}
