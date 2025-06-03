package org.example.application.usecaseimpl;

import org.example.application.gateway.FindWalletByTaxNumberGateway;
import org.example.core.domain.Wallet;
import org.example.core.exception.NotFoundException;
import org.example.core.exception.enums.ErrorCodeEnum;
import org.example.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseimpl implements FindWalletByTaxNumberUseCase {

    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseimpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if(wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getCode(), ErrorCodeEnum.WA0001.getMessage());
        }

        return wallet;
    }
}
