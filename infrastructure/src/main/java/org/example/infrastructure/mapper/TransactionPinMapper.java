package org.example.infrastructure.mapper;

import org.example.core.domain.TransactionPin;
import org.example.infrastructure.entity.TransactionPinEntity;
import org.example.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin){
        return new TransactionPinEntity(
            transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdateAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity){
        return new TransactionPin(
                transactionPinEntity.getId(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getAttempt(),
                transactionPinEntity.getBlocked(),
                transactionPinEntity.getCreatedAt(),
                transactionPinEntity.getCreatedAt());
    }
}
