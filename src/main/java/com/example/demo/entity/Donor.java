package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
 @Entity
public class Donor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String bloodGroup;
    private String contact;

    public Long getId()
    {
        return id;
    }
    public String getBloodGroup()
    {
        return bloodGroup;
    }
    public String getName()
    {
        return name;
    }
    public String getContact()
    {
        return contact;
    }
    public void setContact()
    {
        this.contact = contact;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString()
    {
        return "Donor{" +
                "name=" + this.getName() +
                "," +
                "bloodGroup="+ this.getBloodGroup()+
                "," +
                "contact="+ this.getContact()+
                "}";
    }
}
