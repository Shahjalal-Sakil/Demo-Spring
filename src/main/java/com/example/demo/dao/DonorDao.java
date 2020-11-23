package com.example.demo.dao;

import com.example.demo.entity.Donor;
import org.springframework.context.annotation.Bean;


public interface DonorDao {
    void updateDonor(Donor donor,long id);
}
