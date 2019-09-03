package com.illichso.service.impl;

import com.illichso.model.entity.Account;
import com.illichso.repository.AccountRepository;
import com.illichso.service.AccountService;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Inject
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
