package io.integral.springdemo.Game;

import io.integral.springdemo.Data.GameRoundRecord;
import io.integral.springdemo.Data.GameRoundRecordRepository;

import java.util.ArrayList;
import java.util.List;

public class RoundRepositoryReal implements RoundRepository {

    private GameRoundRecordRepository gameRoundRecordRepository;

    public RoundRepositoryReal(GameRoundRecordRepository gameRoundRecordRepository) {
        this.gameRoundRecordRepository = gameRoundRecordRepository;
    }

    @Override
    public void addRound(Round.Result gameResult) {
        gameRoundRecordRepository.save(new GameRoundRecord(gameResult));
    }

    @Override
    public List<Round> getRounds() {
        List<Round> rounds = new ArrayList<>();
        gameRoundRecordRepository.findAll().forEach(gameRoundRecord ->
                rounds.add(new Round(gameRoundRecord.getResult())));
        return rounds;
    }
}
