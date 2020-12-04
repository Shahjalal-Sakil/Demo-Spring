package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Demo;
import com.example.demo.entity.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
@ConditionalOnProperty(value = "demo.service.imple.id",havingValue = "1")
public class DemoServiceImpl1 implements DemoService {
    @Override
    public String demoAction() {
        return "Implementation 1";
    }

    @Override
    public Demo getDemoClass() {
        String[] friends = {"ABC","CBI"};
        Address address = new Address("Badda","08/B","Dhaka");

        Demo demo = new Demo("Mili",friends,address);
        return demo;
    }

}
