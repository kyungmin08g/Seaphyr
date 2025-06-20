package io.github.kyungmin08g.seaphyr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Configuration
public class TimerConfig {

  @Bean
  public StopWatch stopWatch() {
    return new StopWatch();
  }
}
