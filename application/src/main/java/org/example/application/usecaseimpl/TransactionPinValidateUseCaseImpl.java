package org.example.application.usecaseimpl;

import org.example.application.gateway.TransactionPinValidateGateway;
import org.example.core.domain.TransactionPin;
import org.example.core.exception.PinException;
import org.example.core.exception.TransferException;
import org.example.core.exception.enums.ErrorCodeEnum;
import org.example.usecase.TransactionPinValidateUseCase;
import org.example.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private TransactionPinValidateGateway transactionPinValidateGateway;
    private UpdateTransactionPinUseCase updateTransactionPin;
    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPin) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPin = updateTransactionPin;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransferException, PinException {

        if(transactionPin.getBlocked())
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if(!transactionPinValidateGateway.validate(transactionPin)){
            transactionPin.setAttempt();
            var transactionPinUpdate = updateTransactionPin.update(transactionPin);
            throw new PinException(ErrorCodeEnum.PIN0002.getCode(), ErrorCodeEnum.pin001GetMessage(transactionPinUpdate.getAttempt()));
        }

        if(transactionPin.getAttempt() < 3){
            transactionPin.restaureAttemp();
            updateTransactionPin.update(transactionPin);
        }

        return true;
    }
}
