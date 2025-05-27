package org.example.infrastructure.service;

import org.example.application.gateway.EmailAvailableGateway;
import org.example.infrastructure.repository.UserEntityRepository;

public class EmailAvailableGatewayImpl implements EmailAvailableGateway {

    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean EmailAvailable(String email) {
        return !userEntityRepository.existsByEmail(email);
    }
}
