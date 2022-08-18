package org.example.graceful.task;

import static org.example.graceful.util.Utils.run;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graceful.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledTask {

  private final UserService userService;

  @Scheduled(initialDelayString = "PT10S", fixedDelayString = "PT30S")
  public void task1() {
    log.info("Task 1 started");
    run(1);
    userService
        .findUser("foo_bar")
        .ifPresentOrElse(
            user -> log.info("User found: {}", user), () -> log.warn("User not found"));
    log.info("Task 1 completed");
  }

  @Scheduled(initialDelayString = "PT30S", fixedDelayString = "PT1M")
  public void task2() {
    log.info("Task 2 started");
    run(2);
    log.info("Task 2 completed");
  }
}
