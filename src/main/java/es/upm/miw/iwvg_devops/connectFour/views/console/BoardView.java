package es.upm.miw.iwvg_devops.connectFour.views.console;

import es.upm.miw.iwvg_devops.connectFour.models.Game;
import es.upm.miw.iwvg_devops.connectFour.types.Coordinate;
import es.upm.miw.iwvg_devops.connectFour.views.Message;


public class BoardView {

    void write(Game game) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = 0; i < Coordinate.ROW_SIZE; i++) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Coordinate.COLUMN_SIZE; j++) {
               new ColorView().write(game.getColor(new Coordinate(i,j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            System.out.println();

        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
