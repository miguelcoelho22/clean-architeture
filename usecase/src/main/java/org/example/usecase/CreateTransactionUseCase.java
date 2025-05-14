package org.example.usecase;

import org.example.core.domain.Transaction;

public interface CreateTransactionUseCase {

    void create(Transaction transaction);
}
