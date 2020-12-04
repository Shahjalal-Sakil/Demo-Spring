package com.example.demo.service;

import com.example.demo.entity.Demo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;


public interface DemoService {
    String demoAction();
    Demo getDemoClass();
}
