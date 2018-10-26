package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.Game;
import io.integral.springdemo.Game.RoundRepository;
import io.integral.springdemo.Game.RoundResultPresenter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rockPaperScissors/")
public class GameController {

    private final Game game;

    public GameController(RoundRepository roundRepository) {
        this.game = new Game(roundRepository);
    }

    @PostMapping("play/round")
    public Map<String, String> playRound(@RequestBody PlayRoundRequest body) {
        RoundResultAsJson roundResultAsJson = new RoundResultAsJson();
        game.playRound(body.getPlayer1(), body.getPlayer2(), roundResultAsJson);
        return roundResultAsJson.render();
    }

    @GetMapping("history")
    public List<Map<String, String>> getRoundHistory() {
        HistoryAsJson historyAsJson = new HistoryAsJson();
        game.showRoundHistory(historyAsJson);
        return historyAsJson.render();
    }

}