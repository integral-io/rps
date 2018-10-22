package io.integral.springdemo.Game;

import lombok.Getter;

@Getter
public abstract class RoundResult {
    protected String result;

    public abstract void player1Wins();

    public abstract void player2Wins();
}
