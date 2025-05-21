package org.example.application.gateway;

import org.example.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {

    boolean validate(TransactionPin transactionPin);
}
