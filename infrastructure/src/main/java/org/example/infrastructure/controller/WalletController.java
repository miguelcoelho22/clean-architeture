package org.example.infrastructure.controller;

import org.example.infrastructure.dto.request.TransferRequest;
import org.example.infrastructure.dto.response.BaseResponse;
import org.example.infrastructure.dto.response.ConsultBalanceResponse;
import org.example.usecase.ConsultBalanceUseCase;
import org.example.usecase.TransferUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {

    private ConsultBalanceUseCase consultBalanceUseCase;

    private TransferUseCase transferUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);

        return BaseResponse.<ConsultBalanceResponse>builder().sucess(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        transferUseCase.tranfer(transferRequest.fromTaxNumber(), transferRequest.toTaxNumber(), transferRequest.value(),transferRequest.pin());

        return BaseResponse.<String>builder().sucess(true).message("transferencia realizada").build();
    }
}
