package org.example.infrastructure.service;

import org.example.application.gateway.TaxNumberAvailableGateway;
import org.example.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {

    private final UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean TaxNumberAvailable(String taxNumber) {
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
