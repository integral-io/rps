package io.integral.springdemo.Game;

public class Game {
    public void playRound(String player1, String player2, RoundResult result) {
        if (player1.equals("scissors") && player2.equals("rock")) {
            result.player2Wins();
        } else {
            result.player1Wins();
        }
    }
}
