package org.example.infrastructure.config;

import org.example.application.gateway.CreateUserGateway;
import org.example.application.gateway.EmailAvailableGateway;
import org.example.application.gateway.TaxNumberAvailableGateway;
import org.example.application.usecaseimpl.CreateUserUseCaseImpl;
import org.example.application.usecaseimpl.EmailAvailableUseCaseImpl;
import org.example.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import org.example.usecase.CreateUserUseCase;
import org.example.usecase.EmailAvailableUseCase;
import org.example.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }
    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
