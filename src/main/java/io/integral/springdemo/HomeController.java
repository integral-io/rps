package io.integral.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody
    void greeting() {
    }

    @PostMapping("/playRound")
    public @ResponseBody
    Map<String, String> playRound(@RequestBody Map<String, Object> body) {
        String player1 = (String) body.get("player1");
        String player2 = (String) body.get("player2");
        Map<String, String> results = new HashMap<>();
        if (player1.equals("scissors") && player2.equals("rock")) {
            results.put("result", "player2Wins");
        } else {
            results.put("result", "player1Wins");
        }
        return results;
    }

}