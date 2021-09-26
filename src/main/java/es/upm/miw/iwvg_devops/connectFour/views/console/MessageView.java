package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.views.Message;

public class MessageView {
    public void write(Message message) {
        System.out.print(message.toString());
    }

    public void writeln(Message message) {
        System.out.println(message.toString());
    }

    public void writeln(Message message, String player) {
        assert message == Message.PLAYER_WIN;

        System.out.println(message.toString().replaceAll("#player", "" + player));
    }
}
