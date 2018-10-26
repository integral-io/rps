package io.integral.springdemo.config;

import io.integral.springdemo.Game.RoundRepositoryReal;
import io.integral.springdemo.Data.GameRoundRecordRepository;
import io.integral.springdemo.Game.RoundRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public RoundRepository createRoundRepository(GameRoundRecordRepository repo) {
        return new RoundRepositoryReal(repo);
    }
}
