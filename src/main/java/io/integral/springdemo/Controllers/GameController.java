package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @RequestMapping("/")
    public @ResponseBody
    void greeting() {
    }

    @PostMapping("/playRound")
    public @ResponseBody
    PlayRoundResult playRound(@RequestBody PlayRoundRequest body) {
        PlayRoundResult result = new PlayRoundResult();
        Game game = new Game();
        game.playRound(body.getPlayer1(), body.getPlayer2(), result);
        return result;
    }

}