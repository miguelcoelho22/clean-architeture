package org.example.usecase;

import org.example.core.domain.Transaction;
import org.example.core.domain.TransactionPin;
import org.example.core.exception.PinException;
import org.example.core.exception.TransferException;

public interface TransactionPinValidateUseCase {

    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
