package com.ssline.transferca.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Account {
    private Long id;
    private java.math.BigDecimal amount;

    public Boolean isBalanceGreaterThan(BigDecimal anotherAmount){
        return amount.compareTo(anotherAmount) >= 0;
    }

    public void plus(BigDecimal amount){
        this.amount = this.amount.add(amount);
    }

    public void subtract(BigDecimal amount){
        this.amount = this.amount.subtract(amount);
    }
}
