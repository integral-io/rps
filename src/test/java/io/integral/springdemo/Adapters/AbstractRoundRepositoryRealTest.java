package io.integral.springdemo.Adapters;

import io.integral.springdemo.Data.GameRoundRecordRepository;
import io.integral.springdemo.Game.AbstractRoundRepositoryTest;
import io.integral.springdemo.Game.RoundRepositoryReal;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
public class AbstractRoundRepositoryRealTest extends AbstractRoundRepositoryTest {

    @Autowired
    private GameRoundRecordRepository repository;

    @Before
    public void setup() {
        this.roundRepository = new RoundRepositoryReal(repository);
    }
}
