package io.integral.springdemo.Controllers;

import io.integral.springdemo.Game.Game;
import io.integral.springdemo.Game.GameRoundRepository;
import io.integral.springdemo.Game.RoundResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rockPaperScissors/")
public class GameController {

    private final Game game;
    private GameRoundRepository gameRoundRepository;

    @Autowired
    public GameController(Game game, GameRoundRepository gameRoundRepository) {
        this.game = game;
        this.gameRoundRepository = gameRoundRepository;
    }

    @PostMapping("play/round")
    public @ResponseBody
    RoundResult playRound(@RequestBody PlayRoundRequest body) {
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