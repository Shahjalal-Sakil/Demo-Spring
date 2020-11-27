package com.example.demo;

import com.example.demo.entity.Donor;
import com.example.demo.repository.DonorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileWriter;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class DemorestApplicationTests {

    private static Logger log = LoggerFactory.getLogger(DemorestApplicationTests.class);
    @Test
    void contextLoads() {

    }


}
