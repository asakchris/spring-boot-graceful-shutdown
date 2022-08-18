package org.example.graceful;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class Application implements CommandLineRunner {

  private final Environment env;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) {
    log.info("JAVA_HOME: {}", env.getProperty("JAVA_HOME"));
    log.info("TEST_ENABLED: {}", env.getProperty("TEST_ENABLED"));
    log.info("APP_PASS_PHRASE: {}", env.getProperty("APP_PASS_PHRASE"));
    log.info("JAVA_OPTS: {}", env.getProperty("JAVA_OPTS"));
  }
}
