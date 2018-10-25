package io.integral.springdemo.Game;

import javax.persistence.Entity;

public class GameRound {
    private GameResult result;

    public GameRound(GameResult result) {
        this.result = result;
    }

    public GameResult getResult() {
        return result;
    }
}
