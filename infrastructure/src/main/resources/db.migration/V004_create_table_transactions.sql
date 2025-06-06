create table transactions(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    FromWallet BIGINT NOT NULL,
    ToWallet BIGINT NOT NULL,
    TransactionValue DECIMAL(10, 2) NOT NULL,
    Status VARCHAR(30) NOT NULL,
    CreateAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt DATETIME

    FOREIGN KEY(FromWallet) REFERENCES Wallets(Id),
    FOREIGN KEY(ToWallet) REFERENCES Wallets(Id)
);