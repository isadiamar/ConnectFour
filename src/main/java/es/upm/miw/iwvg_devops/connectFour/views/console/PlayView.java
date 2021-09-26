package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.models.Game;
import es.upm.miw.iwvg_devops.connectFour.views.Message;
import es.upm.miw.iwvg_devops.connectFour.views.WithGameView;

public class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isConnectFour());
        new MessageView().writeln(Message.PLAYER_WIN,this.game.getActiveColor().toString());
    }
}
