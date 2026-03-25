package com.ssline.transferca.application.port.out;

import com.ssline.transferca.domain.Account;

public interface LoadAccountPort {
    Account load(Long id);
}