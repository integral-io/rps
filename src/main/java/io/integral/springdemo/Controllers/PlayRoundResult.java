package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.RoundResult;

public class PlayRoundResult extends RoundResult {
    public void player2Wins() {
        result = "player2Wins";
    }

    public void player1Wins() {
        result = "player1Wins";
    }
}
