package com.example.demo;

import com.example.demo.dao.DonorDao;
import com.example.demo.entity.Donor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class DonorDaoTest {

    @Autowired
    DonorDao donorDao;



    @Test
    void updateDonorTest()
    {
        Donor donor = new Donor();
        donor.setName("TN");
        donor.setBloodGroup("TG");
        donor.setContact("12345");

        donorDao.updateDonor(donor,1);



    }
}
