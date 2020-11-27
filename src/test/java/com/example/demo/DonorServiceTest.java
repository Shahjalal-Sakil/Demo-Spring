package com.example.demo;


import com.example.demo.dao.DonorDao;
import com.example.demo.entity.Donor;
import com.example.demo.model.DonorDto;
import com.example.demo.repository.DonorRepository;
import com.example.demo.service.DonorService;
import com.example.demo.service.DonorServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DonorServiceTest {

    @InjectMocks
    DonorService donorService = new DonorServiceImpl();

    @Mock
    DonorRepository donorRepository;

    @Mock
    DonorDao donorDao;




    @Test
    public void getDonorsTest()
    {
        List<Donor> list = new ArrayList<>();
        list.add(new Donor("TN1","TG2","1"));
        list.add(new Donor("TN2","TG2","2"));
        list.add(new Donor("TN3","TG3","3"));


       doReturn(list).when(donorRepository).findAll();

       List<DonorDto> returnList = donorService.getDonors();

        assertEquals(3,returnList.size());
        //assertThat(returnList).isEqualTo(list);

    }

    @Test
    public void createDonorTest()
    {
        Donor donor = new Donor("TN","TG","1234");

        doReturn(donor).when(donorRepository).save(any(Donor.class));

        DonorDto donorDto = new DonorDto("TN","TG","1234");

        donorService.createDonor(donorDto);
        verify(donorRepository).save(any(Donor.class));
    }

    @Test
    public void getDonorsByBloodGroupTest()
    {
        List<Donor> list = new ArrayList<>();
        list.add(new Donor("TN1","TG","1"));
        list.add(new Donor("TN2","TG","2"));
       doReturn(list).when(donorRepository).findByBloodGroup("TG");

       List<DonorDto> resList = donorService.getDonorsByBloodGroup("TG");

       assertEquals(resList.size(),list.size());

       for(DonorDto donorDto: resList)
       {
           assertEquals(donorDto.getBloodGroup(),"TG");
       }

    }

    @Test
    public void getDonorByIdTest()
    {
        Donor donor = new Donor("TN","TG","1234");

        doReturn(donor).when(donorRepository).getDonorById(1);

        DonorDto donorDto = donorService.getDonorById(1);

        assertEquals(donorDto.getName(),donor.getName());
        assertEquals(donorDto.getBloodGroup(),donor.getBloodGroup());
        assertEquals(donorDto.getContact(),donor.getContact());
    }

    @Test
    public void deleteDonorTest()
    {
        donorService.deleteDonor(1);
        verify(donorRepository).deleteById(1);
    }

    @Test
    public void updateDonorTest()
    {
        Donor donor = new Donor("TN","TG","1234");

        DonorDto donorDto = new DonorDto("TN","TG","1234");

        doNothing().when(donorDao).updateDonor(donor,1L);

        donorService.updateDonor(donorDto,1L);

        verify(donorDao).updateDonor(donor,1L);
    }


}
