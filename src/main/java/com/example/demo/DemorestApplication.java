package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemorestApplication {

    //private static final Logger log = LoggerFactory.getLogger(DemorestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemorestApplication.class, args);
    }
/***
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return  builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate){
        return args -> {
            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
        log.info("This is returned"+ quote.toString());
        };
    }
***/
/***
    @Bean
    public CommandLineRunner demo(DonorRepository donorRepository)
    {
        return (args) ->{
            /***
          donorRepository.save(new Donor("ABC","AB+","12345"));
          donorRepository.save(new Donor("XYZ","A","53737783"));
          donorRepository.save(new Donor("CKY","B","373838"));
            ***/
/***
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for(Donor donor: donorRepository.findAll())
            {
                log.info(donor.toString());
            }
            log.info("");

            for(Donor donor: donorRepository.findByBloodGroup("AB+"))
            {
                log.info(donor.toString());
            }

        };
    }
 ***/
}
