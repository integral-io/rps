package io.integral.springdemo.Game;

import java.util.List;

public interface HistoryPresenter {
    void present(List<GameRound> rounds);
    void presentEmptyHistory();
}
