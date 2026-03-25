package com.ssline.transferca.application.port.in;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyCommand {
    private Long sourceId;
    private Long targetId;
    private BigDecimal amount;
}
