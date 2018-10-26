package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.Round;
import io.integral.springdemo.Game.RoundResultPresenter;

import java.util.HashMap;
import java.util.Map;

public class RoundResultAsJson implements RoundResultPresenter {
    private Map<Round.Result, String> gameResultMap;
    private Round.Result result;

    public RoundResultAsJson() {
        gameResultMap = new HashMap<>();
        gameResultMap.put(Round.Result.INVALID_ROUND, "invalidRound");
        gameResultMap.put(Round.Result.PLAYER_1_WINS, "player1Wins");
        gameResultMap.put(Round.Result.PLAYER_2_WINS, "player2Wins");
        gameResultMap.put(Round.Result.TIE, "tieGame");

    }

    @Override
    public Map<String, String> render() {
        Map<String, String> rendered = new HashMap<>();
        rendered.put("result", gameResultMap.get(result));
        return rendered;
    }

    public void player2Wins() {
        result = Round.Result.PLAYER_2_WINS;
    }

    public void player1Wins() {
        result = Round.Result.PLAYER_1_WINS;
    }


    public void tieGame() {
        result = Round.Result.TIE;
    }

    public void invalidRound() {
        result = Round.Result.INVALID_ROUND;
    }
}
