package com.illichso.configuration.guice.module;

import com.google.inject.AbstractModule;
import com.illichso.repository.AccountRepository;
import com.illichso.repository.impl.AccountRepositoryJPA;
import com.illichso.service.AccountService;
import com.illichso.service.impl.AccountServiceImpl;

public class AccountModule extends AbstractModule {

    protected void configure() {
        bind(AccountService.class).to(AccountServiceImpl.class);
        bind(AccountRepository.class).to(AccountRepositoryJPA.class);
    }

}