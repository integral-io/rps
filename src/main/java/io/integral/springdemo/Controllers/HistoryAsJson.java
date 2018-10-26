package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.HistoryPresenter;
import io.integral.springdemo.Game.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryAsJson implements HistoryPresenter {

    private Map<Round.Result, String> gameResultMap;
    private List<Round> history;


    public HistoryAsJson() {
        gameResultMap = new HashMap<>();
        gameResultMap.put(Round.Result.INVALID_ROUND, "invalidRound");
        gameResultMap.put(Round.Result.PLAYER_1_WINS, "player1Wins");
        gameResultMap.put(Round.Result.PLAYER_2_WINS, "player2Wins");
        gameResultMap.put(Round.Result.TIE, "tieGame");
        history = new ArrayList<>();
    }

    @Override
    public void present(List<Round> rounds) {
        history = rounds;
    }

    @Override
    public void presentEmptyHistory() {
        history = new ArrayList<>();
    }

    private HashMap<String, String> renderOne(Round.Result gameResult) {
        HashMap<String, String> result = new HashMap<>();
        result.put("result", gameResultMap.get(gameResult));
        return result;
    }

    public List<Map<String, String>> render() {
        List<Map<String, String>> output = new ArrayList<>();
        for (Round round : history) {
            output.add(renderOne(round.getResult()));
        }
        return output;
    }
}
