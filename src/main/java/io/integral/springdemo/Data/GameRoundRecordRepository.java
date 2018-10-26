package io.integral.springdemo.Data;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface GameRoundRecordRepository extends Repository<GameRoundRecord, Integer> {

    void save(GameRoundRecord gameRoundRecord);

    List<GameRoundRecord> findAll();
}
