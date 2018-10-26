package io.integral.springdemo.Game;

import java.util.List;

public interface GameRoundRepository {

    void addRound(GameResult gameResult);

    List<GameRound> getRounds();
}
