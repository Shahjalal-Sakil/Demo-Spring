package com.example.demo.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Demo {
    String name;
    String[] friends;
    Address address;

   public Demo(String name, String[] friends,Address address)
    {
        this.name = name;
        this.friends = friends;
        this.address = address;
    }
}
