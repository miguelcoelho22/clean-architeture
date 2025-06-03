package org.example.infrastructure.service;

import org.example.application.gateway.TransactionValidateGateway;
import org.example.core.domain.Transaction;
import org.example.infrastructure.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private TransactionEntityRepository transactionEntityRepository;

    public TransactionValidateGatewayImpl(TransactionEntityRepository transactionEntityRepository) {
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        var transactionSaved = transactionEntityRepository.findById(transaction.getId());
        return transactionSaved.isPresent();
    }
}
