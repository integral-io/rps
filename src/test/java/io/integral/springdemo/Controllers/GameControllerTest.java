package io.integral.springdemo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenRouteIsRequested_thenRouteIsFound() throws Exception {
        this.mockMvc.perform(get("/rockPaperScissors/play/")).andExpect(status().isOk());
    }

    public void assertRound(String postRequest, String expectedResult) throws Exception {
        this.mockMvc.perform(post("/rockPaperScissors/play/round")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postRequest))
                .andExpect(content().json(expectedResult))
                .andExpect(status().isOk());
    }

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
