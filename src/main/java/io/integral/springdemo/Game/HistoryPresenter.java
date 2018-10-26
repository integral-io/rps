package io.integral.springdemo.Game;

import java.util.List;

public interface HistoryPresenter {
    void present(List<Round> rounds);

    void presentEmptyHistory();
}
