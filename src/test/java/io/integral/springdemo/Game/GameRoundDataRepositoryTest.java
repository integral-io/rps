package io.integral.springdemo.Game;

import io.integral.springdemo.Data.GameRoundRecordRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
public class GameRoundDataRepositoryTest extends GameRoundRepositoryTest {

    @Autowired
    private GameRoundRecordRepository repository;

    @Before
    public void setup() {
        this.gameRoundRepository = new GameRoundDataRepository(repository);
    }
}
