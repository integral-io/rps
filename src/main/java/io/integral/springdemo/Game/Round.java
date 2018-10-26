package io.integral.springdemo.Game;

public class Round {

    private Result result;

    public Round(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public enum Result {
        INVALID_ROUND,
        PLAYER_1_WINS,
        PLAYER_2_WINS,
        TIE
    }
}
