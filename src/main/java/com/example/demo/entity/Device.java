package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String os;
    String mac;
    String deviceToken;
    Date createdAt;
    Date updatedAt;

    @Version
    int version;

    @PrePersist
    public void setCreatedAt()
    {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt()
    {
        this.updatedAt = new Date();
    }

}
