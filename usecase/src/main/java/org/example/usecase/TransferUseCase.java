package org.example.usecase;

import org.example.core.domain.Transaction;
import org.example.core.exception.InternalServerErrorException;
import org.example.core.exception.NotFoundException;
import org.example.core.exception.NotficationException;
import org.example.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean tranfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotficationException;
}
