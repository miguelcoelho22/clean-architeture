package org.example.infrastructure.mapper;

import org.example.core.domain.Wallet;
import org.example.infrastructure.entity.TransactionPinEntity;
import org.example.infrastructure.entity.UserEntity;
import org.example.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    private TransactionPinMapper transactionPinMapper;
    private UserMapper userMapper;
    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
            wallet.getBalance(),
            user,
            transactionPinEntity,
            wallet.getCreatedAt(),
            wallet.getUpdateAt()
        );
    }

    public Wallet toWallet(WalletEntity wallet) throws Exception {
        if(wallet == null){
            return null;
        }
        return new Wallet(
                wallet.getId(),
                transactionPinMapper.toTransactionPin(wallet.getTransactionPinEntity()),
                wallet.getBalance(),
                userMapper.toUser(wallet.getUserEntity()),
                wallet.getCreatedAt(),
                wallet.getUpdatedAt());
    }
}
