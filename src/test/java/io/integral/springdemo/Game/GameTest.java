package io.integral.springdemo.Game;

import io.integral.springdemo.Adapters.RoundRepositoryFake;
import io.integral.springdemo.Controllers.HistoryAsJson;
import io.integral.springdemo.Controllers.RoundResultAsJson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    protected Game game;
    protected RoundResultAsJson roundResult;
    protected HistoryPresenter historyPresenter;

    @Before
    public void setup() {
        this.game = new Game(new RoundRepositoryFake());
        this.roundResult = new RoundResultAsJson();
        this.historyPresenter = new HistoryAsJson();
    }

    private void assertRound(String player1, String player2, String expectedResult) {
        game.playRound(player1, player2, roundResult);
        assertEquals(expectedResult, roundResult.render().get("result"));
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
