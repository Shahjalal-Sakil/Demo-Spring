package com.example.demo.service;

import com.example.demo.entity.Donor;
import com.example.demo.model.DonorDto;
import com.example.demo.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {
    @Autowired
    DonorRepository donorRepository;

    @Override
    public List<DonorDto> getDonors() {
        List<DonorDto> donorDtos = new ArrayList<>();
        List<Donor> donors = donorRepository.findAll();
        for (Donor donor:donors)
        {
            DonorDto donorDto = new DonorDto();
            donorDto.setName(donor.getName());
            donorDto.setBloodGroup(donor.getBloodGroup());
            donorDto.setContact(donor.getContact());
            donorDtos.add(donorDto);

        }
        return donorDtos;
    }

    @Override
    public void createDonor(DonorDto donorDto) {
        Donor donor = new Donor();
        donor.setName(donorDto.getName());
        donor.setBloodGroup(donorDto.getBloodGroup());
        donor.setContact(donorDto.getContact());
        donorRepository.save(donor);
    }

    @Override
    public List<DonorDto> getDonorsByBloodGroup(String bloodGroup) {
        List<DonorDto> donorDtos = new ArrayList<>();
        List<Donor> donors = donorRepository.findByBloodGroup(bloodGroup);

        for (Donor donor:donors)
        {
            DonorDto donorDto = new DonorDto();
            donorDto.setName(donor.getName());
            donorDto.setBloodGroup(donor.getBloodGroup());
            donorDto.setContact(donor.getContact());
            donorDtos.add(donorDto);

        }
        return donorDtos;
    }

    @Override
    public DonorDto getDonorById(long id) {
        Donor donor = donorRepository.getDonorById(id);
        DonorDto donorDto = new DonorDto();
        donorDto.setName(donor.getName());
        donorDto.setBloodGroup(donor.getBloodGroup());
        donorDto.setContact(donor.getContact());
        return donorDto;
    }

    @Override
    public DonorDto updateDonor(DonorDto donorDtou, long id) {
        int flag= donorRepository.updateDonor(
          donorDtou.getName(),donorDtou.getBloodGroup(),donorDtou.getContact(),id
        );


        return donorDtou;


    }

    @Override
    public void deleteDonor(long id) {
        donorRepository.deleteById(id);
    }
}
