package io.integral.springdemo.Game;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameRoundRepositoryTest {
    private GameRoundRepositoryFake gameRoundRepository;

    @Before
    public void setup() {
        this.gameRoundRepository = new GameRoundRepositoryFake();
    }

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
        assertEquals(size.intValue(), gameRoundRepository.getHistorySize());
        assertEquals(result, gameRoundRepository.getRoundResult(round));
    }

    @Test
    public void clearAllPreviousGames_thenSizeEqualsZero() {
        gameRoundRepository.addRound(GameResult.PLAYER_1_WINS);
        assertTrue(gameRoundRepository.getHistorySize() > 0);
        gameRoundRepository.clearRounds();
        assertEquals(0, gameRoundRepository.getHistorySize());
    }
}
