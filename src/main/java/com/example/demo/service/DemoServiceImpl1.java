package com.example.demo.service;

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
}
