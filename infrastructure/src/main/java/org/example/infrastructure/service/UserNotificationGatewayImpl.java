package org.example.infrastructure.service;

import org.example.application.gateway.UserNotificationGateway;
import org.example.core.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {


    @Override
    public boolean notificate(Transaction transaction, String email) {
        return true;
    }
}
