package com.example.demo.service;

import com.example.demo.dao.DonorDao;
import com.example.demo.entity.Donor;
import com.example.demo.model.DonorDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.DonorRepository;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface DonorService {


    List<DonorDto> getDonors();
    void createDonor(DonorDto donorDto);
    List<DonorDto> getDonorsByBloodGroup(String bloodGroup);
    DonorDto getDonorById(long id);
    //DonorDto updateDonor(DonorDto donorDto ,long id);
    void deleteDonor(long id);
    void updateDonor(DonorDto donorDto,long id);
}
