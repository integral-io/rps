package io.integral.springdemo.Game;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class GameRoundRepositoryFake implements GameRoundRepository {
    private List<GameRound> rounds;

    public GameRoundRepositoryFake() {
        rounds = new ArrayList<>();
    }

    public void addRound(GameResult gameResult) {
        rounds.add(new GameRound(gameResult));
    }

    public List<GameRound> getRounds() {
        return rounds;
    }
}
