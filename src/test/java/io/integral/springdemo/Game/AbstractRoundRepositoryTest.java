package io.integral.springdemo.Game;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public abstract class AbstractRoundRepositoryTest {
    protected RoundRepository roundRepository;

    @Test
    public void whenARoundIsPlayed_thenOutcomeMatchesRoundsPlayed() {
        roundRepository.addRound(Round.Result.PLAYER_1_WINS);
        assertRoundHistory(1, 0, Round.Result.PLAYER_1_WINS);
    }

    @Test
    public void whenMoreThanARoundIsPlayed_thenAllOutcomesMatch() {
        roundRepository.addRound(Round.Result.PLAYER_1_WINS);
        assertRoundHistory(1, 0, Round.Result.PLAYER_1_WINS);
        roundRepository.addRound(Round.Result.PLAYER_2_WINS);
        assertRoundHistory(2, 1, Round.Result.PLAYER_2_WINS);
        assertRoundHistory(2, 0, Round.Result.PLAYER_1_WINS);
    }

    private void assertRoundHistory(Integer size, Integer round, Round.Result result) {
        assertEquals(size.intValue(), roundRepository.getRounds().size());
        assertEquals(result, roundRepository.getRounds().get(round).getResult());
    }

}
