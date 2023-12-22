package com.phdesk.helpdesk.config;

import com.phdesk.helpdesk.services.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBservice dBservice;

    @Bean
    public void instanciaDB(){
        dBservice.instanciaDB();
    }
}
