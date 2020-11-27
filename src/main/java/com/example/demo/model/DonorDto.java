package com.example.demo.model;
import com.example.demo.entity.Donor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorDto {
    private String name;
    private String bloodGroup;
    private String contact;
}
