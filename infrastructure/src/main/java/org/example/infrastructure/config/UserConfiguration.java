package org.example.infrastructure.config;

import org.example.usecase.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public CreateUserUseCase createUserUseCase(){

    }
}
