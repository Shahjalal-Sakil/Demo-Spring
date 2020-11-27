package com.example.demo.entity;

import com.example.demo.annotations.AdderClass;
import com.example.demo.annotations.NotZero;
import com.example.demo.annotations.NumberIncrement;


@AdderClass
public class Number {

    private int a;

    @NumberIncrement
    @NotZero
    private int b;

    @NumberIncrement
    private int c;

    public Number(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
