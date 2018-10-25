package io.integral.springdemo.Game;

import java.util.List;
import java.util.Map;

public interface OutcomePresenterInterface {
    List<Map<String, String>> getResults();
    void addResults(List<GameRound> rounds);
}
