package com.illichso.service.impl;

import com.illichso.exception.UserNotFoundException;
import com.illichso.model.entity.Account;
import com.illichso.model.entity.User;
import com.illichso.repository.AccountRepository;
import com.illichso.repository.UserRepository;
import com.illichso.service.AccountService;

import javax.inject.Inject;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Inject
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account saveAccount(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        Account account = new Account(user);
        return accountRepository.save(account);
    }

    public List<User> getAllAccounts() {
        return userRepository.findAll();
    }
}
