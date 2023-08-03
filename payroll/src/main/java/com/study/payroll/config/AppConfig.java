package com.study.payroll.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //Creating a component, like @Component with one method to return a Singleton that's going to be available to inject
    //in others components

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
