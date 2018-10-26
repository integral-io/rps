package io.integral.springdemo.Adapters;

import io.integral.springdemo.Game.Round;
import io.integral.springdemo.Game.RoundRepository;

import java.util.ArrayList;
import java.util.List;

public class RoundRepositoryFake implements RoundRepository {
    private List<Round> rounds;

    public RoundRepositoryFake() {
        rounds = new ArrayList<>();
    }

    public void addRound(Round.Result gameResult) {
        rounds.add(new Round(gameResult));
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
