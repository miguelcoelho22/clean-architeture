package org.example.usecase;

import org.example.core.domain.Transaction;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction);
}
