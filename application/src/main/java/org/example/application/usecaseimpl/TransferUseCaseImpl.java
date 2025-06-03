package org.example.application.usecaseimpl;

import org.example.application.gateway.TransferGateway;
import org.example.core.domain.Transaction;
import org.example.core.domain.Wallet;
import org.example.core.exception.*;
import org.example.core.exception.enums.ErrorCodeEnum;
import org.example.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private FindWalletByTaxNumberUseCase fIndUserByTestNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;

    private TransactionPinValidateUseCase transactionPinValidateUseCase;
    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase fIndUserByTestNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.fIndUserByTestNumberUseCase = fIndUserByTestNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }


    @Override
    public Boolean tranfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws Exception {
        Wallet from = fIndUserByTestNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = fIndUserByTestNumberUseCase.findByTaxNumber(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveTransfer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if(!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getCode(), ErrorCodeEnum.TR0003.getMessage());
        }

        if(!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())){
            throw new NotficationException(ErrorCodeEnum.NO0001.getCode(), ErrorCodeEnum.NO0001.getMessage());
        }

        return  true;
    }
}
