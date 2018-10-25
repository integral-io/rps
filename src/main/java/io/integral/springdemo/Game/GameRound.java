package io.integral.springdemo.Game;

public class GameRound implements GameRoundInterface {
    private GameResult result;

    public GameRound(GameResult result) {
        this.result = result;
    }

    @Override
    public GameResult getResult() {
        return result;
    }
}
