package com.example.demo.entity;

import com.example.demo.entity.Device;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    long age;


    @ManyToOne(targetEntity = Device.class,fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "device_id"),name = "device_id")
    @JsonBackReference
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
