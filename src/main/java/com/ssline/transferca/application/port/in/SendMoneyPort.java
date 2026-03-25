package com.ssline.transferca.application.port.in;

public interface SendMoneyPort {
    public boolean send(SendMoneyCommand command);
}
