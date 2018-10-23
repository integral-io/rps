package io.integral.springdemo.Controllers;

import org.junit.Test;

abstract public class AbstractGameControllerTest {


    protected abstract void assertRound(String requestBody, String expectedResult) throws Exception;

    @Test
    public void whenP1PlaysRock_andP2PlaysScissors_thenP1Wins() throws Exception {
        assertRound(
                "{\"player1\": \"rock\", \"player2\": \"scissors\"}",
                "{\"result\": \"player1Wins\"}"
        );
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysPaper_thenP1Wins() throws Exception {
        assertRound(
                "{\"player1\": \"scissors\", \"player2\": \"paper\"}",
                "{\"result\": \"player1Wins\"}"
        );
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysRock_thenP2Wins() throws Exception {
        assertRound(
                "{\"player1\": \"scissors\", \"player2\": \"rock\"}",
                "{\"result\": \"player2Wins\"}"
        );
    }
}
