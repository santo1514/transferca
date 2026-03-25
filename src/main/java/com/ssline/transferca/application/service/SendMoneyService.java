package com.ssline.transferca.application.service;

import com.ssline.transferca.application.port.in.SendMoneyCommand;
import com.ssline.transferca.application.port.in.SendMoneyPort;
import com.ssline.transferca.application.port.out.LoadAccountPort;
import com.ssline.transferca.application.port.out.UpdateAccountPort;
import com.ssline.transferca.common.UseCase;
import com.ssline.transferca.domain.Account;
import jakarta.transaction.Transactional;

@UseCase
public class SendMoneyService implements SendMoneyPort{

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;

    public SendMoneyService(LoadAccountPort loadAccountPort, UpdateAccountPort updateAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.updateAccountPort = updateAccountPort;
    }

    @Transactional
    @Override
    public boolean send(SendMoneyCommand command) {
        Account source = loadAccountPort.load(command.getSourceId());
        Account target = loadAccountPort.load(command.getTargetId());
        if(!source.isBalanceGreaterThan(command.getAmount())) {
            throw new RuntimeException("Source account not have enough balance amount ... ");
        }
        target.plus(command.getAmount());
        source.subtract(command.getAmount());
        updateAccountPort.update(source);
        updateAccountPort.update(target);
        return true;
    }
    
}
