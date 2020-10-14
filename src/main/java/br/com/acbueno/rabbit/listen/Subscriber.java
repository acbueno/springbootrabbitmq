package br.com.acbueno.rabbit.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(Subscriber.class);
  
  @Autowired
  Queue queue;
  
  @RabbitListener(queues = "#{queue.getName()}")
  public void receive(final String message) {
    LOGGER.info("Listen message from queue!!");
    LOGGER.info("Recevied the following message from the queue= " + message);
    LOGGER.info("Message received successfully from the queue.");
  }

}
