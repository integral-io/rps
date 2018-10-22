package io.integral.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody void greeting() {
    }

    @RequestMapping("/playRound/{player1}/{player2}")
    public @ResponseBody String playRound(@PathVariable String player1, @PathVariable String player2) {
        if (player1.equals("scissors") && player2.equals("rock")) {
            return "{\"result\": \"player2Wins\"}";
        }
        return "{\"result\": \"player1Wins\"}";
    }

}