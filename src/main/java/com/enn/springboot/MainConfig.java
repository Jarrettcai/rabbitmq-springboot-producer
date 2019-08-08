package com.enn.springboot;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.enn.springboot"})
public class MainConfig {
    @Bean
    public TopicExchange exchange_1() {
        return new TopicExchange("exchange_1", true, false);
    }

    @Bean
    public Queue queue_1() {
        return new Queue("queue_1", true, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue_1()).to(exchange_1()).with("springboot.*");
    }
}
