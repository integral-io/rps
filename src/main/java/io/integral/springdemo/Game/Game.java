package io.integral.springdemo.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Game {

    private List<String> validShapes = Arrays.asList("rock", "paper", "scissors");
    private GameRoundRepository gameRoundRepository;

    @Autowired
    public Game(GameRoundRepository gameRoundRepository) {
        this.gameRoundRepository = gameRoundRepository;
    }

    public void playRound(String player1, String player2, RoundResult result) {
        if(isInvalidShape(player1) || isInvalidShape(player2)) {
            result.invalidRound();
        } else if (player2Wins(player1, player2)) {
            result.player2Wins();
        } else if(isTie(player1, player2)){
            result.tieGame();
        } else {
            result.player1Wins();
        }

        gameRoundRepository.addRound(result.getGameResult());
    }

    private boolean player2Wins(String player1, String player2) {
        return player1.equals("scissors") && player2.equals("rock") ||
            player1.equals("paper") && player2.equals("scissors") ||
            player1.equals("rock") && player2.equals("paper");
    }

    private boolean isTie(String player1, String player2) {
        return player1.equals(player2);
    }

    private boolean isInvalidShape(String shape) {
        return !validShapes.contains(shape);
    }

    public void showRoundHistory(HistoryPresenter outcomePresenter) {
        outcomePresenter.present(gameRoundRepository.getRounds());
    }
}
