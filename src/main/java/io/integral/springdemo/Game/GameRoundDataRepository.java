package io.integral.springdemo.Game;

import io.integral.springdemo.Data.GameRoundRecord;
import io.integral.springdemo.Data.GameRoundRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameRoundDataRepository implements GameRoundRepository {

    private GameRoundRecordRepository gameRoundRecordRepository;

    public GameRoundDataRepository(GameRoundRecordRepository gameRoundRecordRepository) {
        this.gameRoundRecordRepository = gameRoundRecordRepository;
    }

    @Override
    public void addRound(GameResult gameResult) {
        gameRoundRecordRepository.save(new GameRoundRecord(gameResult));
    }

    @Override
    public List<GameRound> getRounds() {
        List<GameRound> rounds = new ArrayList<>();
        gameRoundRecordRepository.findAll().forEach(gameRoundRecord ->
            rounds.add(new GameRound(gameRoundRecord.getResult())));
        return rounds;
    }
}
