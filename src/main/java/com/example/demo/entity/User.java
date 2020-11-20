package com.example.demo.entity;

import com.example.demo.entity.Device;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    long age;


    @ManyToOne(targetEntity = Device.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "deviceId")
    private Device device;

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
