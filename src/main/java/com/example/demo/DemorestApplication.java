package com.example.demo;

import com.example.demo.entity.Donor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@EnableCaching
public class DemorestApplication {

    //private static final Logger log = LoggerFactory.getLogger(DemorestApplication.class);
    @Autowired
    private Environment env;

    public static void main(String[] args) {

        SpringApplication.run(DemorestApplication.class, args);
    }

    @Bean(name="dataSource")
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

/**
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)throws Exception{
        Properties properties = new Properties();
        properties.put("hibernate.dialect",env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", //
                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        //localSessionFactoryBean.setPackagesToScan(new String[]{""});
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.afterPropertiesSet();

        SessionFactory sf = localSessionFactoryBean.getObject();
        return sf;
    }
**/
   /* @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
        return hibernateTransactionManager;
    }*/


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
