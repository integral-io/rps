package io.integral.springdemo.Controllers;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest extends AbstractGameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    public void assertRound(String requestBody, String expectedResult) throws Exception {
        this.mockMvc.perform(post("/rockPaperScissors/play/round")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(content().json(expectedResult))
                .andExpect(status().isOk());
    }
}
