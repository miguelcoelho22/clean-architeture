package org.example.application.usecaseimpl;

import org.example.application.gateway.UserNotificationGateway;
import org.example.core.domain.Transaction;
import org.example.usecase.UserNotificationUseCase;

public class userNotificationUseCaseImpl implements UserNotificationUseCase {

    private UserNotificationGateway userNotificationGateway;
    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
