package io.integral.springdemo.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GameRoundRecord {
    @Id
    @GeneratedValue()
    private Integer id;
    private GameResult result;

    public GameRoundRecord() {}

    public GameResult getResult() {
        return result;
    }

    public Integer getId() {
        return id;
    }
}
