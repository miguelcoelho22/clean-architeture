package org.example.application.gateway;

import org.example.core.domain.TransactionPin;
import org.example.core.domain.User;
import org.example.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet, TransactionPin transactionPin);
}
