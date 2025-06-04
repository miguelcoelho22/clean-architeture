package org.example.application.usecaseimpl;

import org.example.application.gateway.UpdateTransactionPinGateway;
import org.example.core.domain.TransactionPin;
import org.example.usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase {

    private UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return updateTransactionPinGateway.update(transactionPin);
    }
}
