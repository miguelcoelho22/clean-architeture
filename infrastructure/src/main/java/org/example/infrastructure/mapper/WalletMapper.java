package org.example.infrastructure.mapper;

import org.example.core.domain.Wallet;
import org.example.infrastructure.entity.TransactionPinEntity;
import org.example.infrastructure.entity.UserEntity;
import org.example.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPinEntity){
        return new WalletEntity(
            wallet.getBalance(),
            user,
            transactionPinEntity,
            wallet.getCreatedAt(),
            wallet.getUpdateAt()
        );
    }
}
