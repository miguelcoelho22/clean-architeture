package org.example.application.usecaseimpl;

import org.example.application.gateway.TransactionValidateGateway;
import org.example.core.domain.Transaction;
import org.example.core.exception.InternalServerErrorException;
import org.example.core.exception.TransferException;
import org.example.core.exception.enums.ErrorCodeEnum;
import org.example.usecase.TransactionValidateUseCase;


public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private TransactionValidateGateway transactionValidateGateway;
    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if(!transactionValidateGateway.validate(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0004.getCode(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }
}
