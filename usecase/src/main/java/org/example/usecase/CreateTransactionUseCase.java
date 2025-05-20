package org.example.usecase;

import org.example.core.domain.Transaction;
import org.example.core.exception.TransferException;

public interface CreateTransactionUseCase {

    Transaction create(Transaction transaction) throws TransferException;
}
