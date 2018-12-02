package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.increasePoints();
        } else if (playerName.equals(player2.getName())) {
            player2.increasePoints();
        }
    }

    public String getScore() {
        if (player1.getPoints() == player2.getPoints()) {
            return getEqualScore();
        } else if (player1.getPoints() >= 4 || player2.getPoints() >= 4) {
            return getAdvantageScore();
        } else {
            return getBasicScore();
        }
    }

    private String getBasicScore() {
        String score = "";
        int points;
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                points = player1.getPoints();
            } else {
                score += "-";
                points = player2.getPoints();
            }
            score += pointsToScore(points);
        }
        return score;
    }

    private String pointsToScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getEqualScore() {
        switch (player1.getPoints()) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String getAdvantageScore() {
        int difference = player1.getPoints() - player2.getPoints();
        if (difference == 1) {
            return "Advantage player1";
        } else if (difference == -1) {
            return "Advantage player2";
        } else if (difference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

}