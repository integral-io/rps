package io.integral.springdemo.Data;

import io.integral.springdemo.Game.Round;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameRoundRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Round.Result result;

    public GameRoundRecord() {
    }

    public GameRoundRecord(Round.Result gameResult) {
        result = gameResult;
    }

    public Round.Result getResult() {
        return result;
    }

    public Integer getId() {
        return id;
    }
}
