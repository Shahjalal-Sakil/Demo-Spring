package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;


@Data
@Document
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialId = 45L;
    @Id
    long id;
    String name;
    String author;
    long price;
}
