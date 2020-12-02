package com.example.demo.component;

import com.example.demo.conf.MessageQueueConfiguration;
import com.example.demo.entity.Request;
import com.example.demo.entity.Response;
import com.example.demo.repository.ResponseRepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientRequestMaker {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    private static final String ROUTING_KEY = "prime.request";

    @Autowired
    ResponseRepository responseRepository;

    public ClientRequestMaker(RabbitTemplate rabbitTemplate, DirectExchange directExchange)
    {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void send(Request request)
    {

        rabbitTemplate.convertAndSend(directExchange.getName(),ROUTING_KEY,request);
        Response response = new Response(request.getCorrelationId(),0,false);

        responseRepository.save(response);

    }

/*
    @RabbitListener(queues = "response-queue")
    public void get(Response response, Message message)
    {
            System.out.println(response.toString());
    }
*/
}
