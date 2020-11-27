package com.example.demo.service;

public class ExceptionsClass extends RuntimeException {
    private static final long id = 101L;

    public ExceptionsClass(String message)
    {
        super(message);
    }
}
