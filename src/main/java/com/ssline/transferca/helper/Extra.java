package com.ssline.transferca.helper;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.ssline.transferca.adapter.out.persistence.AccountEntity;
import com.ssline.transferca.adapter.out.persistence.SpringAccountRepository;

@Component
public class Extra implements InitializingBean{
    
    private final SpringAccountRepository extra;

    public Extra(SpringAccountRepository springAccountRepository) {
        extra = springAccountRepository;
    }

    @SuppressWarnings("null")
    @Override
    public void afterPropertiesSet() throws Exception {
        extra.save(AccountEntity.builder().amount(BigDecimal.valueOf(100)).build());
        extra.save(AccountEntity.builder().amount(BigDecimal.valueOf(300)).build());
    }
}
