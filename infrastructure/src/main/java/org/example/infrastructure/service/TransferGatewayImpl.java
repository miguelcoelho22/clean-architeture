package org.example.infrastructure.service;

import jakarta.transaction.Transactional;
import org.example.application.gateway.TransferGateway;
import org.example.core.domain.Transaction;
import org.example.infrastructure.mapper.TransactionMapper;
import org.example.infrastructure.mapper.WalletMapper;
import org.example.infrastructure.repository.TransactionEntityRepository;
import org.example.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferGatewayImpl implements TransferGateway {

    private WalletEntityRepository walletEntityRepository;
    private TransactionEntityRepository transactionEntityRepository;
    private WalletMapper walletMapper;

    private TransactionMapper transactionMapper;
    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getToWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getFromWallet()));

            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            return true;
        }catch (Exception e){
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
        }
    }
}
