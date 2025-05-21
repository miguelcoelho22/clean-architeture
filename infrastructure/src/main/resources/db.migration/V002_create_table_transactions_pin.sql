create table TransactionsPin(

    Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Pin VARCHAR(50) NOT NULL,
    Attempt INT NOT NULL,
    Blocked Bool NOT NULL,
    CreateAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt DATETIME
);