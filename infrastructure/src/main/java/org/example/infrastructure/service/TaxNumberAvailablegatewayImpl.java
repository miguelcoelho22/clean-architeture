package org.example.infrastructure.service;

import org.example.application.gateway.TaxNumberAvailableGateway;
import org.example.infrastructure.repository.UserEntityRepository;

public class TaxNumberAvailablegatewayImpl implements TaxNumberAvailableGateway {

    private final UserEntityRepository userEntityRepository;

    public TaxNumberAvailablegatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean TaxNumberAvailable(String taxNumber) {
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
