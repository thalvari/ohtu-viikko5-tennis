package ohtu;

public class Player {

    int points = 0;
    String name;

    public Player(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void increasePoints() {
        points++;
    }

}
