package com.example.demo.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Book{
    @Id
    long id;
    String name;
    String author;
    long price;
}
