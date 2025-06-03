package org.example.application.usecaseimpl;

import org.example.application.gateway.CreateTransactionGateway;
import org.example.core.domain.Transaction;
import org.example.core.exception.TransferException;
import org.example.core.exception.enums.ErrorCodeEnum;
import org.example.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws Exception {
        var transactionSaved =  createTransactionGateway.create(transaction);

        if(transactionSaved == null){
            throw new TransferException(ErrorCodeEnum.TR0003.getCode(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
