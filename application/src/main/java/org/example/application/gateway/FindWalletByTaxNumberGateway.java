package org.example.application.gateway;

import org.example.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
