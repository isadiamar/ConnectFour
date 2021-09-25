package es.upm.miw.iwvg_devops.connectFour;

import es.upm.miw.iwvg_devops.connectFour.types.Color;
import es.upm.miw.iwvg_devops.connectFour.types.Message;

import java.util.Scanner;

public class Player {

    private final Color color;
    private final Board board;
    int MAX_TOKENS = Coordinate.ROW_SIZE * Coordinate.COLUMN_SIZE;
    private int putTokens;

    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    public void play() {
        if (this.putTokens < MAX_TOKENS) {
            this.putTokens();
        }
    }

    private void putTokens() {

        Message.ENTER_COLUMN_TO_PUT.writeln(this.color.toString());
        Scanner sc = new Scanner(System.in);

        int userColumn = sc.nextInt();

        this.board.putToken(userColumn, this.color);
        this.putTokens++;
    }

    public void writeWinner() {
        Message.PLAYER_WIN.writeln(this.color.toString());
    }

    public Color getColor() {
        return this.color;
    }
}
