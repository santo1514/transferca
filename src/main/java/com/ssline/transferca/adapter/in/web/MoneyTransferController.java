package com.ssline.transferca.adapter.in.web;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssline.transferca.application.port.in.SendMoneyCommand;
import com.ssline.transferca.application.port.in.SendMoneyPort;
import com.ssline.transferca.common.WebAdapter;

@WebAdapter
@RestController
public class MoneyTransferController {
    
    private final SendMoneyPort sendMoneyPort;

    public MoneyTransferController(SendMoneyPort sendMoneyPort) {
        this.sendMoneyPort = sendMoneyPort;
    }

    @PostMapping(path = "/accounts/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
    ResponseEntity<Boolean> transfer(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") BigDecimal amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                sourceAccountId,
                targetAccountId,
                amount);

        return ResponseEntity.ok(sendMoneyPort.send(command));
    }


}
