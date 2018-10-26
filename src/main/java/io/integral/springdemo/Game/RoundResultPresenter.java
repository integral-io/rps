package io.integral.springdemo.Game;

import java.util.Map;

public interface RoundResultPresenter {
    Map<String, String> render();

    void player2Wins();

    void player1Wins();

    void tieGame();

    void invalidRound();
}
