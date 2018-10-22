package io.integral.springdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        this.mockMvc.perform(get("/playRound/rock/scissors"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"player1\": \"rock\", \"player2\": \"scissors\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\": \"player1Wins\"}"));
        /*
        mockMvc.perform(
            post("/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(user)))
            .andExpect(status().isCreated())
            .andExpect(header().string("location", containsString("http://localhost/users/")));
    verify(userService, times(1)).exists(user);
    verify(userService, times(1)).create(user);
    verifyNoMoreInteractions(userService);
         */
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysPaper_thenP1Wins() throws Exception {
        this.mockMvc.perform(get("/playRound/scissors/paper"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\": \"player1Wins\"}"));
    }

    @Test
    public void whenP1PlaysScissors_andP2PlaysRock_thenP2Wins() throws Exception {
        this.mockMvc.perform(get("/playRound/scissors/rock"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"result\": \"player2Wins\"}"));
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
