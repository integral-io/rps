package io.integral.springdemo;

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
public class SpringDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void whenRouteIsRequested_thenRouteIsFound() throws Exception {
        // //How to write an API test in Spring Boot?
        // We want to ensure our request is routed correctly
        // if we send GET /shapes
        // then return not 404
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void whenP1PlaysRock_andP2PlaysScissors_thenP1Wins() throws Exception {
        this.mockMvc.perform(post("/playRound")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"player1\": \"rock\", \"player2\": \"scissors\"}"))
                .andExpect(content().json("{\"result\": \"player1Wins\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysPaper_thenP1Wins() throws Exception {
        this.mockMvc.perform(post("/playRound")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"player1\": \"scissors\", \"player2\": \"paper\"}"))
                .andExpect(content().json("{\"result\": \"player1Wins\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysRock_thenP2Wins() throws Exception {
        this.mockMvc.perform(post("/playRound")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"player1\": \"scissors\", \"player2\": \"rock\"}"))
                .andExpect(content().json("{\"result\": \"player2Wins\"}"))
                .andExpect(status().isOk());
    }
}
/*
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
}
 */
