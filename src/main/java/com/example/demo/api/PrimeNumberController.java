package com.example.demo.api;


import com.example.demo.component.ClientRequestMaker;
import com.example.demo.conf.MessageQueueConfiguration;
import com.example.demo.entity.Request;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PrimeNumberController {

    @Autowired
    ClientRequestMaker requestMaker;

    @GetMapping(value = "/prime/{num}")
    public UUID getNthPrime(@PathVariable int num)
    {
        UUID correlationId = UUID.randomUUID();
        Request request = new Request(correlationId,num);
        requestMaker.send(request);
        return correlationId;
    }
/*
    @GetMapping(value = "/prime/{ref}")
    @RabbitListener(queues = "message-queue")
    public long getAnswer(@PathVariable String ref)
    {


        return 0;
    }

 */
}
