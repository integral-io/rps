package io.integral.springdemo.Data;

import io.integral.springdemo.Game.GameResult;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameRoundRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private GameResult result;

    public GameRoundRecord() {}

    public GameRoundRecord(GameResult gameResult) {
        result = gameResult;
    }

    public GameResult getResult() {
        return result;
    }

    public Integer getId() {
        return id;
    }
}
