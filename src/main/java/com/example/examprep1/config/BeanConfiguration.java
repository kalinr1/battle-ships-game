package com.example.examprep1.config;

import com.example.examprep1.models.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    @SessionScope
    public LoggedUser loggedUser (){
        return new LoggedUser();
    }
}
