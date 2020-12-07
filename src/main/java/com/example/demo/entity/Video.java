package com.example.demo.entity;

import com.example.demo.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "created_by")
    private User user;

    String fileName;
    String url;

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
