package io.integral.springdemo.Game;

import io.integral.springdemo.Controllers.OutcomePresenter;
import io.integral.springdemo.Controllers.RoundResultPresenter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    private Game game;
    private RoundResultPresenter roundResult;
    private OutcomePresenterInterface outcomePresenter;

    @Before
    public void setup() {
        this.game = new Game();
        this.roundResult = new RoundResultPresenter();
        this.outcomePresenter = new OutcomePresenter();
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

//    @Test
//    public void whenNoRoundsArePlayed_thenNoOutcomesReturned() {
//        game.showRoundHistory(outcomePresenter);
//        assertEquals(0, outcomePresenter.getResults().size());
//    }
//
//
//    @Test
//    public void whenARoundIsPlayed_thenOutcomeMatchesRoundsPlayed() {
//        game.playRound("rock", "scissors", this.roundResult);
//        assertRoundHistory(1, 0, this.roundResult.getResult());
//    }
//
//    @Test
//    public void whenMoreThanARoundIsPlayed_thenAllOutcomesMatch() {
//        RoundResultInterface r1 = new RoundResultPresenter();
//        game.playRound("rock", "scissors", r1);
//        String result1 = r1.getResult();
////        assertRoundHistory(1, 0, result1);
//
//        RoundResultInterface r2 = new RoundResultPresenter();
//        game.playRound("scissors", "rock", r2);
//        String result2 = r2.getResult();
//        assertRoundHistory(2, 1, result2);
//        assertRoundHistory(2, 0, result1);
//    }
//
//    private void assertRoundHistory(Integer size, Integer round, String result) {
//        game.showRoundHistory(outcomePresenter);
//        assertEquals(size.intValue(), outcomePresenter.getResults().size());
//        assertEquals(result, outcomePresenter.getResults().get(round));
//    }
}
