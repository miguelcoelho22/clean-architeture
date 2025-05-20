package org.example.usecase;

import org.example.core.domain.User;
import org.example.core.exception.EmailException;
import org.example.core.exception.InternalServerErrorException;
import org.example.core.exception.TaxNumberException;
import org.example.core.exception.TransactionPinException;

public interface CreateUserUseCase {

    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
