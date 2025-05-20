package org.example.usecase;

import org.example.core.domain.Transaction;
import org.example.core.exception.TransferException;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction) throws TransferException;
}
