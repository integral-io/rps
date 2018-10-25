package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.Game;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest extends AbstractGameControllerTest {
//    @Autowired
//    private MockMvc mockMvc;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GameController(new Game())).build();
    }

    public void assertRound(String requestBody, String expectedResult) throws Exception {
        this.mockMvc.perform(post("/rockPaperScissors/play/round")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(content().json(expectedResult))
                .andExpect(status().isOk());
    }

    @Override
    protected void playRound(String requestBody) throws Exception {
        this.mockMvc.perform(post("/rockPaperScissors/play/round")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
    }

    @Override
    protected void assertRoundHistory(String expectedResult) throws Exception {
        this.mockMvc.perform(get("/rockPaperScissors/history")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedResult))
                .andExpect(status().isOk());
    }
}
