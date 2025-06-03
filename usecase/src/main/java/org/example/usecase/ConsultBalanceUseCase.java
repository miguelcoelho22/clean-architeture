package org.example.usecase;

import org.example.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consult(String taxNumber) throws Exception;
}
