package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.GameResult;
import io.integral.springdemo.Game.GameRound;
import io.integral.springdemo.Game.HistoryPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Getter
public class HistoryAsJson implements HistoryPresenter {

    private Map<GameResult, String> gameResultMap;
    private List<GameRound> history;


    public HistoryAsJson() {
        gameResultMap = new HashMap<>();
        gameResultMap.put(GameResult.INVALID_ROUND, "invalidRound");
        gameResultMap.put(GameResult.PLAYER_1_WINS, "player1Wins");
        gameResultMap.put(GameResult.PLAYER_2_WINS, "player2Wins");
        gameResultMap.put(GameResult.TIE, "tieGame");
        history = new ArrayList<>();
    }

    @Override
    public void present(List<GameRound> rounds) {
        history = rounds;
    }

    @Override
    public void presentEmptyHistory() {
        history = new ArrayList<>();
    }

    private HashMap<String, String> renderOne(GameResult gameResult) {
        HashMap<String, String> result = new HashMap<>();
        result.put("result", gameResultMap.get(gameResult));
        return result;
    }

    public List<Map<String, String>> render() {
        List<Map<String, String>> output = new ArrayList<>();
        for(GameRound round : history) {
            output.add(renderOne(round.getResult()));
        }
        return output;
    }
}
