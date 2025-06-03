package org.example.infrastructure.service;

import jakarta.transaction.Transactional;
import org.example.application.gateway.CreateUserGateway;
import org.example.core.domain.User;
import org.example.core.domain.Wallet;
import org.example.infrastructure.entity.WalletEntity;
import org.example.infrastructure.mapper.TransactionPinMapper;
import org.example.infrastructure.mapper.UserMapper;
import org.example.infrastructure.mapper.WalletMapper;
import org.example.infrastructure.repository.TransactionPinEntityRepository;
import org.example.infrastructure.repository.UserEntityRepository;
import org.example.infrastructure.repository.WalletEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {


    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;
    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try{
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
