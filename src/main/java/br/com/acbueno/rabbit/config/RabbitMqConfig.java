package br.com.acbueno.rabbit.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;


@Configuration
public class RabbitMqConfig {

  @Value("${rabbitmq.queue}")
  private String queueName;

  @Value("${rabbitmq.exchange}")
  private String exchange;

  @Value("${rabbitmq.routingkey}")
  private String routingKey;

  @Bean
  Queue queue() {
    return new Queue(queueName, Boolean.FALSE);
  }

  @Bean
  TopicExchange topicExchange() {
    return new TopicExchange(exchange);
  }

  @Bean
  Binding binding(final Queue queue, final TopicExchange topicExchange) {
    return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
  }

}
