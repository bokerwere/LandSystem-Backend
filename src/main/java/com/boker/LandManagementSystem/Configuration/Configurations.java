package com.boker.LandManagementSystem.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }
}
