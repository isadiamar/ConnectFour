package es.upm.miw.iwvg_devops.connectFour;

import es.upm.miw.iwvg_devops.connectFour.models.Game;

import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        boolean keepPlaying = true;

        while (keepPlaying) {
            Game game = new Game();
            game.play();

            keepPlaying = checkKeepPlaying();
        }
    }

    private static boolean checkKeepPlaying() {
        boolean res = false;

        System.out.println("Do you want to start a new game? (y/n): ");
        Scanner sc = new Scanner(System.in);
        char userResponse = sc.next().charAt(0);

        if (userResponse == 'y')
            res = true;

        return res;
    }
}

