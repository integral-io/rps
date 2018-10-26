package io.integral.springdemo.Game;

import java.util.List;

public interface RoundRepository {

    void addRound(Round.Result gameResult);

    List<Round> getRounds();
}
