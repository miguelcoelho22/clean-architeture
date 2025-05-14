package org.example.usecase;

import org.example.core.domain.User;

public interface FIndUserByTestNumberUseCase {

    User findByTaxNumber(String taxNumber);
}
