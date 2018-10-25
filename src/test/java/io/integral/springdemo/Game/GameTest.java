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
    private HistoryPresenter historyPresenter;

    @Before
    public void setup() {
        this.game = new Game(new GameRoundRepositoryFake());
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
}
