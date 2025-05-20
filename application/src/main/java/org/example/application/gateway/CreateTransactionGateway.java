package org.example.application.gateway;

import org.example.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction crate(Transaction transaction);
}
