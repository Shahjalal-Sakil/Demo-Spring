package com.example.demo;

import com.example.demo.entity.Donor;
import com.example.demo.repository.DonorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class DonorRepositoryTest {

    private static Logger log = LoggerFactory.getLogger(DonorRepositoryTest.class);

    @Autowired
    DonorRepository donorRepository;


    @Test
    void injectedComponentsAreNotNull()
    {
        assertThat(donorRepository).isNotNull();
    }

    @Test
    public void createNewDonorTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("1234");


       Donor d = donorRepository.save(donor);
        log.info("After Creation");

        Optional <Donor> data = donorRepository.findById(d.getId());
        log.info("Get Result");

       if(data.isPresent())
       {
           Donor donorTest = data.get();
           assertThat(donorTest.getName()).isEqualTo("TN");
           assertThat(donorTest.getBloodGroup()).isEqualTo("TG");
           assertThat(donorTest.getContact()).isEqualTo("1234");
       }


    }

    @Test
    void getDonorTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("1234");
        donorRepository.save(donor);

        List<Donor> lists = donorRepository.findAll();
        assertThat(lists.size()).isEqualTo(1);
    }

    @Test
    void getDonorsByBloodGroupTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("1234");

        donorRepository.save(donor);
        List<Donor> donors = donorRepository.findByBloodGroup("TG");
        for(Donor d:donors)
        {
            assertThat(d.getBloodGroup()).isEqualTo("TG");
        }

    }

    @Test
    void getDonorByIdTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("1234");

        Donor d = donorRepository.save(donor);
        Optional <Donor> data = donorRepository.findById(d.getId());


            Donor donorTest = data.get();
            assertThat(donorTest.getName()).isEqualTo("TN");
            assertThat(donorTest.getBloodGroup()).isEqualTo("TG");
            assertThat(donorTest.getContact()).isEqualTo("1234");


    }

    @Test
    void deleteDonorTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("1234");

        Donor d = donorRepository.save(donor);

        donorRepository.deleteById(d.getId());
        List<Donor> data = donorRepository.findByBloodGroup("TG");
        assertThat(data.size()).isEqualTo(0);
    }

    @Test
    void updateDonorTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("1234");

        Donor d = donorRepository.save(donor);

        Optional<Donor> data1 = donorRepository.findById(d.getId());
        Donor d1 = data1.get();
        d1.setContact("1111");

        donorRepository.save(d1);

        Optional<Donor> data2 = donorRepository.findById(d.getId());
        Donor d2 = data2.get();


        assertThat(d2.getContact()).isEqualTo("1111");
        assertThat(d2.getContact()).isNotEqualTo("1234");


    }




}
