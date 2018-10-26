package io.integral.springdemo.Adapters;

import io.integral.springdemo.Game.AbstractRoundRepositoryTest;
import org.junit.Before;

public class AbstractRoundRepositoryFakeTest extends AbstractRoundRepositoryTest {
    @Before
    public void setup() {
        this.roundRepository = new RoundRepositoryFake();
    }
}
