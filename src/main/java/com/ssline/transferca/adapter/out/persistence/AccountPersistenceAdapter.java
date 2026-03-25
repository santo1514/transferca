package com.ssline.transferca.adapter.out.persistence;


import com.ssline.transferca.application.port.out.LoadAccountPort;
import com.ssline.transferca.application.port.out.UpdateAccountPort;
import com.ssline.transferca.common.PersistenceAdapter;
import com.ssline.transferca.domain.Account;

@SuppressWarnings("null")
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new); // mejorar exception
    }

   
    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }
}
