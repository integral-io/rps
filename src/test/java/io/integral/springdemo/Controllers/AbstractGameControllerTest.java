package io.integral.springdemo.Controllers;

import org.junit.Test;

abstract public class AbstractGameControllerTest {

    protected abstract void assertRound(String requestBody, String expectedResult) throws Exception;

    protected abstract void playRound(String requestBody) throws Exception;

    protected abstract void assertRoundHistory(String expectedResult) throws Exception;

    @Test
    public void testThatPlayer1Wins() throws Exception {
        assertRound(
                "{\"player1\": \"rock\", \"player2\": \"scissors\"}",
                "{\"result\": \"player1Wins\"}"
        );
    }

    @Test
    public void testThatARoundIsRemembered() throws Exception {
        playRound("{\"player1\": \"rock\", \"player2\": \"scissors\"}");
        assertRoundHistory("[{\"result\": \"player1Wins\"}]");
    }

    @Test
    public void testThatTwoRoundsAreRemembered() throws Exception {
        playRound("{\"player1\": \"rock\", \"player2\": \"scissors\"}");
        playRound("{\"player1\": \"scissors\", \"player2\": \"rock\"}");
        assertRoundHistory("[{\"result\": \"player1Wins\"}, {\"result\": \"player2Wins\"}]");
    }

}
