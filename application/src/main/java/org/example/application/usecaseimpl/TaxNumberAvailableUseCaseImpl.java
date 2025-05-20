package org.example.application.usecaseimpl;

import org.example.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvailableUseCase.taxNumberAvailable(taxNumber);
    }
}
