package org.example.application.gateway;

import org.example.core.domain.Transaction;

public interface TransferGateway {

    Boolean transfer(Transaction transaction);
}
