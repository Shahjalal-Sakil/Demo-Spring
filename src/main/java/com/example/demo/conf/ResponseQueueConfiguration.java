package com.example.demo.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class ResponseQueueConfiguration {
    static final String exchangeName = "prime-response-exchange";
    static final String queueName = "response-queue";

    @Bean
    Queue response()
    {
        return new Queue(queueName);
    }

    @Bean
    @Qualifier("response")
    DirectExchange directExchangeResponse()
    {
        return new DirectExchange(exchangeName);
    }

    @Bean
    Binding bindingResponse(Queue response, DirectExchange directExchangeResponse)
    {
        return BindingBuilder.bind(response).to(directExchangeResponse).with("prime.response");
    }

    @Bean
    AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate)
    {
        return new AsyncRabbitTemplate(rabbitTemplate);
    }

}
