package org.example.usecase;

import org.example.core.domain.User;
import org.example.core.domain.Wallet;
import org.example.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
