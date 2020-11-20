package com.example.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;



public class DemoServiceImpl1 implements DemoService {
    @Override
    public String demoAction() {
        return "Implementation 1";
    }
}
