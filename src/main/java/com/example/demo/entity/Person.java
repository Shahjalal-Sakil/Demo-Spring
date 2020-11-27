package com.example.demo.entity;

import com.example.demo.annotations.JsonSerializable;
import com.example.demo.annotations.JsonElement;
import com.example.demo.annotations.JsonInit;


@JsonSerializable
public class Person {

    @JsonElement
    private String firstName;

    @JsonElement
    private String lastName;

    @JsonElement(key = "personAge")
    private String age;

    private String address;

    public Person(String firstName, String lastName)
    {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String age)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @JsonInit
    private void init()
    {
            this.firstName = "First Name: "+ this.firstName;
            this.lastName = "Last Name: " + this.lastName;
    }



}
