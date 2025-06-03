package org.example.application.gateway;

import org.example.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);
}
