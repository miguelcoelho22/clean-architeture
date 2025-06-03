package org.example.infrastructure.service;

import org.example.application.gateway.CreateTransactionGateway;
import org.example.core.domain.Transaction;
import org.example.infrastructure.mapper.TransactionMapper;
import org.example.infrastructure.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) throws Exception {
        try {
            var transactionEntity = transactionMapper.createTransaction(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        }catch (Exception e) {
            return null;
        }
    }
}
