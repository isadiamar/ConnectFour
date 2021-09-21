package es.upm.miw.iwvg_devops.connectFour;

import java.util.Scanner;

public class Turn {
    private Player player;
    private Board board;

    public Turn(Player player, Board board) {
        this.player = player;
        this.board = board;
    }

    public void play() {
        boolean isValidColumn = false;

        board.display();

        while (!isValidColumn) {
            System.out.println(this.player.getName() + ", choose the column: ");
            Scanner sc = new Scanner(System.in);
            int chosenColumn = sc.nextInt() - 1;

            try {
                board.addToken(chosenColumn, player.getToken());
                isValidColumn = true;
            } catch (Exception e) {
                System.out.println("Column not valid");
            }
        }
    }

    public boolean isWinner() {
        boolean res = false;
        res = board.hasWinner(player.getToken());
        return res;
    }
}
