package br.com.acbueno.rabbit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.core.Binding;

@RestController
@RequestMapping("/api")
public class Publisher {
  
  @Autowired
  RabbitTemplate rabbitTemplate;
  
  @Autowired
  Binding binding;
  
  private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);
  
  @GetMapping(value = "/send/{msg}")
  @ResponseStatus(code = HttpStatus.OK)
  public String send(@PathVariable("msg") final String message) {
    LOGGER.info("Sending message to the queue");
    rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
    LOGGER.info("Message sent succeesfully to queue, sending back to the response to the user");
    return "Message sent sucessfully to the queue";
  }

}
