package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String os;
    String mac;
    String deviceToken;
    Date createdAt;
    Date updatedAt;

    @OneToMany(mappedBy = "device")
    @JsonManagedReference
    List<User> users;

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
