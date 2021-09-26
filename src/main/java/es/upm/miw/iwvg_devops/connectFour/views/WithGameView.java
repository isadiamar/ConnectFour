package es.upm.miw.iwvg_devops.connectFour.views;

import es.upm.miw.iwvg_devops.connectFour.models.Game;

public abstract class WithGameView {
    protected Game game;

    protected WithGameView(Game game) {
        this.game = game;
    }
}
