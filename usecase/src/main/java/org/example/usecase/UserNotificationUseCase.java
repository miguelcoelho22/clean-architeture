package org.example.usecase;

import org.example.core.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean notificate(Transaction transaction, String email);
}
