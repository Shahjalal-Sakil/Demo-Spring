package com.example.demo;

import com.example.demo.entity.Donor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
public class DemorestApplication {

    //private static final Logger log = LoggerFactory.getLogger(DemorestApplication.class);
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Donor.class);
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/myDb");
        properties.put("hibernate.connection.username", "sakil");
        properties.put("hibernate.connection.password", "12345");
        properties.put("show_sql", "true");
        properties.put("hbm2ddl.auto", "update");
        properties.put("hibernate.current_session_context_class","thread");
        configuration.setProperties(properties);
         sessionFactory = configuration.buildSessionFactory();

        SpringApplication.run(DemorestApplication.class, args);
    }

    public SessionFactory getSessionFactory()
    {

        return sessionFactory;
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
