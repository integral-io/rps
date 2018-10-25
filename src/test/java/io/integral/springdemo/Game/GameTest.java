package io.integral.springdemo.Game;

import io.integral.springdemo.Controllers.HistoryAsJson;
import io.integral.springdemo.Controllers.RoundResultPresenter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game;
    private RoundResultPresenter roundResult;
    private HistoryPresenterInterface historyPresenter;

    @Before
    public void setup() {
        this.game = new Game();
        this.roundResult = new RoundResultPresenter();
        this.historyPresenter = new HistoryAsJson();
    }

    private void assertRound(String player1, String player2, String expectedResult) {
        game.playRound(player1, player2, roundResult);
        assertEquals(expectedResult, roundResult.getResult());
    }

    @Test
    public void whenP1PlaysRock_andP2PlaysScissors_thenP1Wins() {
        assertRound("rock", "scissors", "player1Wins");
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysPaper_thenP1Wins() {
        assertRound("scissors", "paper", "player1Wins");
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysRock_thenP2Wins() {
        assertRound("scissors", "rock", "player2Wins");
    }

    @Test
    public void whenP1PlaysPaper_andP2PlaysScissors_thenP2Wins() {
        assertRound("paper", "scissors", "player2Wins");
    }

    @Test
    public void whenP1PlaysRock_andP2PlaysPaper_thenP2Wins() {
        assertRound("rock", "paper", "player2Wins");
    }

    @Test
    public void whenP1PlaysRock_andP2PlaysRock_thenTie() {
        assertRound("rock", "rock", "tieGame");
    }

    @Test
    public void whenP1PlaysInvalid_orP2PlaysInvalid_thenTie() {
        assertRound("cat", "rock", "invalidRound");
        assertRound("rock", "dog", "invalidRound");
        assertRound("cat", "dog", "invalidRound");
    }


    @Test
    public void whenARoundIsPlayed_thenOutcomeMatchesRoundsPlayed() {
        game.playRound("rock", "scissors", this.roundResult);
        assertRoundHistory(1, 0, GameResult.PLAYER_1_WINS);
    }

    @Test
    public void whenMoreThanARoundIsPlayed_thenAllOutcomesMatch() {
        game.playRound("rock", "scissors", new RoundResultPresenter());
        assertRoundHistory(1, 0, GameResult.PLAYER_1_WINS);

        game.playRound("scissors", "rock", new RoundResultPresenter());
        assertRoundHistory(2, 1, GameResult.PLAYER_2_WINS);
        assertRoundHistory(2, 0, GameResult.PLAYER_1_WINS);
    }

    private void assertRoundHistory(Integer size, Integer round, GameResult result) {
        game.showRoundHistory(historyPresenter);
        assertEquals(size.intValue(), game.getHistorySize());
        assertEquals(result, game.getRoundResult(round));
    }

    @Test
    public void clearAllPreviousGames_thenSizeEqualsZero() {
        RoundResultInterface r1 = new RoundResultPresenter();
        game.playRound("rock", "scissors", r1);
        game.showRoundHistory(historyPresenter);
        assertTrue(game.getHistorySize() > 0);
        game.clearRounds();
        assertEquals(0, game.getHistorySize());
    }
}
