package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.GameResult;
import io.integral.springdemo.Game.GameRound;
import io.integral.springdemo.Game.OutcomePresenterInterface;
import io.integral.springdemo.Game.RoundResultInterface;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Getter
public class OutcomePresenter implements OutcomePresenterInterface {

    private Map<GameResult, String> gameResultMap;
    private List<Map<String, String>> results;

    @Override
    public List<Map<String, String>> getResults() {
        return results;
    }

    public OutcomePresenter() {
        gameResultMap = new HashMap<>();
        gameResultMap.put(GameResult.INVALID_ROUND, "invalidRound");
        gameResultMap.put(GameResult.PLAYER_1_WINS, "player1Wins");
        gameResultMap.put(GameResult.PLAYER_2_WINS, "player2Wins");
        gameResultMap.put(GameResult.TIE, "tieGame");
        results = new ArrayList<>();
    }

    @Override
    public void addResults(List<GameRound> rounds) {
        for(GameRound round : rounds) {
            addResult(round);
        }
    }

    public void addResult(GameRound round) {
        HashMap<String, String> result = new HashMap<>();
        result.put("result", render(round.getResult()));
        results.add(result);
    }

    private String render(GameResult gameResult) {
        return gameResultMap.get(gameResult);
    }
}
