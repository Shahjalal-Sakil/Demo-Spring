package com.example.demo.conf;

import com.example.demo.DemorestApplication;
import com.example.demo.service.DemoService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.service.DemoServiceImpl1;
import com.example.demo.service.DemoServiceImpl2;


public class AppConf {

    private String id;

    //private static final Logger log =  LoggerFactory.getLogger(DemorestApplication.class);
    public DemoService getDemoService()
    {
        if(id.equals("1"))
            return new DemoServiceImpl1();
        else
            return new DemoServiceImpl2();
    }

}
