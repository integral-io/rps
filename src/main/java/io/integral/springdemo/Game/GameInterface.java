package io.integral.springdemo.Game;

public interface GameInterface {
    void playRound(String Player1, String Player2, RoundResultInterface roundResultInterface);
    void showRoundHistory(HistoryPresenterInterface outcomePresenter);
    void clearRounds();
}
