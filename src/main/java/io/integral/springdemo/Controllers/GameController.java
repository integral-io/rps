package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.GameInterface;
import io.integral.springdemo.Game.RoundResultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rockPaperScissors/")
public class GameController {

    private final GameInterface game;

    @Autowired
    public GameController(GameInterface game) {
        this.game = game;
    }

    @PostMapping("play/round")
    public @ResponseBody
    RoundResultInterface playRound(@RequestBody PlayRoundRequest body) {
        RoundResultPresenter result = new RoundResultPresenter();
        game.playRound(body.getPlayer1(), body.getPlayer2(), result);
        return result;
    }

    @GetMapping("history")
    public List<Map<String, String>> getRoundHistory() {
        HistoryAsJson historyAsJson = new HistoryAsJson();
        game.showRoundHistory(historyAsJson);
        return historyAsJson.render();
    }

}