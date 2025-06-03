package org.example.application.usecaseimpl;

import org.example.usecase.ConsultBalanceUseCase;
import org.example.usecase.FindWalletByTaxNumberUseCase;
import org.example.usecase.TaxNumberAvailableUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        return findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber).getBalance();
    }
}
