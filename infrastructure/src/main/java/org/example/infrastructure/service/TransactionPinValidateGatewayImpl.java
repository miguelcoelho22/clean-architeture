package org.example.infrastructure.service;

import org.example.application.gateway.TransactionPinValidateGateway;
import org.example.application.gateway.TransactionValidateGateway;
import org.example.core.domain.Transaction;
import org.example.core.domain.TransactionPin;
import org.example.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) {
        var transactionPinSaved =  transactionPinEntityRepository.findById(transactionPin.getId());
        if(transactionPinSaved.isEmpty()){
            return false;
        }
        if(!Objects.equals(transactionPinSaved.get().getPin(), transactionPin.getPin())){
            return false;
        }

        return true;
    }
}
