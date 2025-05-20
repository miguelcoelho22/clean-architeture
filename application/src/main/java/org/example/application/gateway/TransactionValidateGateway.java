package org.example.application.gateway;

import org.example.core.domain.Transaction;

public interface TransactionValidateGateway {

    Boolean validate(Transaction transaction);
}
