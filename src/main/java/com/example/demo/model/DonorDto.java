package com.example.demo.model;
import com.example.demo.entity.Donor;
import lombok.Data;

@Data
public class DonorDto {
    private String name;
    private String bloodGroup;
    private String contact;
}
