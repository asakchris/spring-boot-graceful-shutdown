package org.example.graceful.jms;

import java.time.LocalDateTime;
import javax.jms.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {

  @Qualifier("queueOne")
  private final Queue queue;

  private final JmsTemplate jmsTemplate;

  @Scheduled(initialDelayString = "PT5S", fixedDelayString = "PT1M")
  public void queue1() {
    log.info("Queue 1 producer started");
    String message = "Message generated at " + LocalDateTime.now();
    jmsTemplate.convertAndSend(queue, message);
    log.info("Queue 1 producer completed");
  }
}
