package es.upm.miw.iwvg_devops.connectFour;

public class Player {
    private int number;
    private String name;

    public Player(String name, int number) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return "Player " + this.name;
    }

    public char getToken() {
        return Character.forDigit(this.number, 10);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
