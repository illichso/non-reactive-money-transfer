package com.illichso.repository;

import com.illichso.model.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);

    Account findOne(int userId);

    void deleteAll();

    List<Account> findAll();
}
