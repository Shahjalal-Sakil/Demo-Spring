package com.example.demo.component;


import com.example.demo.entity.Request;
import com.example.demo.entity.Response;
import com.example.demo.repository.ResponseRepository;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrimeGenerator {
    private final AsyncRabbitTemplate rabbitTemplate;
    private final DirectExchange directExchangeResponse;
    private static final String ROUTING_KEY = "prime.response";

    @Autowired
    ResponseRepository responseRepository;

    public PrimeGenerator(AsyncRabbitTemplate rabbitTemplate,@Qualifier("response") DirectExchange directExchangeResponse)
    {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchangeResponse = directExchangeResponse;
    }

    @RabbitListener(queues = "request-queue")
    public void computePrime(Request request) throws InterruptedException {
        int num = request.getNum();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long prime = getNthPrime(num);
                Response response = new Response(request.getCorrelationId(),prime,true);
                pushResponse(response);
            }
        };
        new Thread(runnable).start();
    }

    public void pushResponse(Response response)
    {
        /*
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties
                    = message.getMessageProperties();
            messageProperties.setReplyTo("response-queue");
            messageProperties.setCorrelationId(response.getCorrelationId().toString());
            return message;
        };

        rabbitTemplate.convertSendAndReceive(directExchangeResponse.getName(),ROUTING_KEY,response,messagePostProcessor);
   */

        responseRepository.save(response);
    }


    public long getNthPrime(int n)
    {
        int num, count, i;
        num=1;
        count=0;

        while (count < n){
            num=num+1;
            for (i = 2; i <= num; i++){
                if (num % i == 0) {
                    break;
                }
            }
            if ( i == num){
                count = count+1;
            }
        }
        return num;
    }

}
