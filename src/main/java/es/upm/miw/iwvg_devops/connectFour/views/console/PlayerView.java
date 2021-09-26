package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.models.Game;
import es.upm.miw.iwvg_devops.connectFour.views.Message;

import java.util.Scanner;

public class PlayerView {
    private final Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() {
        if (!this.game.areAllTokensOnBoard()) {
            this.putToken();
        }else{
            new MessageView().writeln(Message.FULL_BOARD);
            new ResumeView(this.game).interact();
        }
    }

    private void putToken() {
        int userColumn = getColumn();
        this.game.putToken(userColumn);
    }

    int getColumn() {
        new  MessageView().writeln(Message.ENTER_COLUMN_TO_PUT, this.game.getActiveColor().toString());
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}





