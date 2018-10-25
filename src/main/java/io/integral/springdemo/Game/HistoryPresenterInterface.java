package io.integral.springdemo.Game;

import java.util.List;

public interface HistoryPresenterInterface {
    void present(List<GameRound> rounds);
    void presentEmptyHistory();
}
