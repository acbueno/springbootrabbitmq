package br.com.acbueno.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBootRabbitApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootRabbitApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringBootRabbitApplication.class, args);
    LOGGER.info("Springboot application with rabbitmq started successfully.");
  }

}
