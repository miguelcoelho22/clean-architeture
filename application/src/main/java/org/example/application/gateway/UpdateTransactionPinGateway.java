package org.example.application.gateway;

import org.example.core.domain.TransactionPin;

public interface UpdateTransactionPinGateway {

    TransactionPin update(TransactionPin transactionPin);
}
