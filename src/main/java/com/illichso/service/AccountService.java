package com.illichso.service;

import com.illichso.model.entity.Account;
import com.illichso.model.entity.User;

import java.util.List;

public interface AccountService {

    Account saveAccount(int userId);

    List<User> getAllAccounts();
}
