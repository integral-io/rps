package io.integral.springdemo.Game;

public interface RoundResultInterface {
    String getResult();
    GameResult getGameResult();

    void player2Wins();
    void player1Wins();
    void tieGame();
    void invalidRound();
}
