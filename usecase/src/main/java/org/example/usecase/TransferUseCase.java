package org.example.usecase;

import org.example.core.domain.Transaction;
import org.example.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean tranfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException, TransferException, NotFoundException, NotficationException, PinException;
}
