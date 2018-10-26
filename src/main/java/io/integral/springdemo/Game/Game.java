package io.integral.springdemo.Game;

import java.util.Arrays;
import java.util.List;

public class Game {

    private List<String> validShapes = Arrays.asList("rock", "paper", "scissors");
    private RoundRepository roundRepository;

    public Game(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public void playRound(String player1, String player2, RoundResultPresenter result) {
        Round.Result roundResult;
        if (isInvalidShape(player1) || isInvalidShape(player2)) {
            result.invalidRound();
            roundResult = Round.Result.INVALID_ROUND;
        } else if (player2Wins(player1, player2)) {
            result.player2Wins();
            roundResult = Round.Result.PLAYER_2_WINS;
        } else if (isTie(player1, player2)) {
            result.tieGame();
            roundResult = Round.Result.TIE;
        } else {
            result.player1Wins();
            roundResult = Round.Result.PLAYER_1_WINS;
        }

        roundRepository.addRound(roundResult);
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
        List<Round> rounds = roundRepository.getRounds();
        if (rounds.isEmpty()) {
            outcomePresenter.presentEmptyHistory();
        } else {
            outcomePresenter.present(roundRepository.getRounds());
        }
    }
}
