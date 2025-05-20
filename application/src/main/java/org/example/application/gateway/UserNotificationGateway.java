package org.example.application.gateway;

import org.example.core.domain.Transaction;

public interface UserNotificationGateway {

    boolean notificate(Transaction transaction, String email);
}
