package com.rishant.Enterprise.Management.System.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
@Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
