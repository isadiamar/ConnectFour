package es.upm.miw.iwvg_devops.connectFour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int MAX_PLAYERS = 2;
    Player activePlayer;
    Player winnerPlayer;
    private Board board;
    private List<Player> players;

    public Game() {
        this.board = new Board();
        this.players = generatePlayers();
        this.activePlayer = players.get(0);
        this.winnerPlayer = null;
    }

    public void play() {
        System.out.println("New game started!");

        while (winnerPlayer == null) {
            Turn turn = new Turn(activePlayer, board);
            turn.play();
            if (turn.isWinner()) {
                winnerPlayer = activePlayer;
            } else {
                activePlayer = changePlayer(activePlayer, players);
            }
        }

        board.display();
        System.out.println(winnerPlayer.getName() + " is the winner!");
    }

    private List<Player> generatePlayers() {
        List<Player> res = new ArrayList<>();

        for (int i = 0; i < MAX_PLAYERS; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player " + (i + 1) + " Introduce your name: ");
            String userName = sc.next();
            res.add(new Player(userName, (i + 1)));
        }
        return res;
    }

    private Player changePlayer(Player prevPlayer, List<Player> players) {
        Player res = null;
        if (prevPlayer == players.get(0)) {
            res = players.get(1);
        } else {
            res = players.get(0);
        }
        return res;
    }
}
