package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.GameResult;
import io.integral.springdemo.Game.RoundResult;

import java.util.HashMap;
import java.util.Map;

public class RoundResultPresenter implements RoundResult {
    private Map<GameResult, String> gameResultMap;

    public RoundResultPresenter() {
        gameResultMap = new HashMap<>();
        gameResultMap.put(GameResult.INVALID_ROUND, "invalidRound");
        gameResultMap.put(GameResult.PLAYER_1_WINS, "player1Wins");
        gameResultMap.put(GameResult.PLAYER_2_WINS, "player2Wins");
        gameResultMap.put(GameResult.TIE, "tieGame");

    }

    @Override
    public String getResult() {
        return gameResultMap.get(result);
    }

    @Override
    public GameResult getGameResult() {
        return result;
    }

    private GameResult result;

    public void player2Wins() {
        result = GameResult.PLAYER_2_WINS;
    }

    public void player1Wins() {
        result = GameResult.PLAYER_1_WINS;
    }


    public void tieGame() {
        result = GameResult.TIE;
    }

    public void invalidRound() {
        result = GameResult.INVALID_ROUND;
    }
}
