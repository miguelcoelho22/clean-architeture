package org.example.infrastructure.service;

import org.example.application.gateway.FindWalletByTaxNumberGateway;
import org.example.core.domain.Wallet;
import org.example.infrastructure.mapper.WalletMapper;
import org.example.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;
    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
