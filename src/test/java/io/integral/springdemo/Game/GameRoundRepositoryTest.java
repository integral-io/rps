package io.integral.springdemo.Game;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class GameRoundRepositoryTest {
    protected GameRoundRepository gameRoundRepository;

    @Test
    public void whenARoundIsPlayed_thenOutcomeMatchesRoundsPlayed() {
        gameRoundRepository.addRound(GameResult.PLAYER_1_WINS);
        assertRoundHistory(1, 0, GameResult.PLAYER_1_WINS);
    }

    @Test
    public void whenMoreThanARoundIsPlayed_thenAllOutcomesMatch() {
        gameRoundRepository.addRound(GameResult.PLAYER_1_WINS);
        assertRoundHistory(1, 0, GameResult.PLAYER_1_WINS);
        gameRoundRepository.addRound(GameResult.PLAYER_2_WINS);
        assertRoundHistory(2, 1, GameResult.PLAYER_2_WINS);
        assertRoundHistory(2, 0, GameResult.PLAYER_1_WINS);
    }

    private void assertRoundHistory(Integer size, Integer round, GameResult result) {
        assertEquals(size.intValue(), gameRoundRepository.getRounds().size());
        assertEquals(result, gameRoundRepository.getRounds().get(round).getResult());
    }

}
