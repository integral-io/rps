package io.integral.springdemo.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRoundRepositoryFake implements GameRoundRepository {
    private List<GameRound> rounds;

    public GameRoundRepositoryFake() {
        rounds = new ArrayList<>();
    }

    public void clearRounds() {
        rounds.clear();
    }

    public int getHistorySize() {
        return rounds.size();
    }

    public GameResult getRoundResult(Integer round) {
        return getRounds().get(round).getResult();
    }

    public void addRound(GameResult gameResult) {
        rounds.add(new GameRound(gameResult));
    }

    public List<GameRound> getRounds() {
        return rounds;
    }
}
