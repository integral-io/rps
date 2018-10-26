package io.integral.springdemo.Game;

import org.junit.Before;

public class GameRoundRepositoryFakeTest extends GameRoundRepositoryTest {
    @Before
    public void setup() {
        this.gameRoundRepository = new GameRoundRepositoryFake();
    }
}
