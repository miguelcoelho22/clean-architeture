package org.example.repository;

import org.example.entity.TransactionEntity;
import org.example.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {


}
