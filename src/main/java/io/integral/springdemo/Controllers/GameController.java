package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.Game;
import io.integral.springdemo.Game.RoundResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rockPaperScissors/play")
public class GameController {

    @RequestMapping("/")
    public @ResponseBody
    void greeting() {
    }

    @PostMapping("/round")
    public @ResponseBody
    PlayRoundResult playRound(@RequestBody PlayRoundRequest body) {
        PlayRoundResult result = new PlayRoundResult();
        Game game = new Game();
        game.playRound(body.getPlayer1(), body.getPlayer2(), result);
        return result;
    }

}