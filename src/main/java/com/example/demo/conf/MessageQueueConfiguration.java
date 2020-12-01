package com.example.demo.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class MessageQueueConfiguration {
    static final String exchangeName = "prime-request-exchange";
    static final String queueName = "request-queue";

    @Bean
    Queue request()
    {
        return new Queue(queueName);
    }

    @Bean
    DirectExchange directExchange()
    {
        return new DirectExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue request, DirectExchange directExchange)
    {
        return BindingBuilder.bind(request).to(directExchange).with("prime.request");
    }
    @Bean
    public MessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
