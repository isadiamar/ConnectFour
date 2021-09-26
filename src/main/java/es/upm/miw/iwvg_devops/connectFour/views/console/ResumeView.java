package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.models.Game;
import es.upm.miw.iwvg_devops.connectFour.utils.YesNoDialog;
import es.upm.miw.iwvg_devops.connectFour.views.Message;
import es.upm.miw.iwvg_devops.connectFour.views.WithGameView;

public class ResumeView extends WithGameView {

    ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.game.reset();
        }
        return isResumed.isAffirmative();
    }
}
