package es.upm.miw.iwvg_devops.connectFour.models;

public class Game {
    private final Board board;
    private final Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void play() {
        System.out.println("New game started!");

        while(!this.board.isTicTacToe(this.turn.getActiveColor())){
            Turn turn = new Turn(this.board);
            Player activePlayer = turn.getActivePlayer();


    }
    }


}

