package com.illichso.configuration.guice.module;

import com.google.inject.AbstractModule;
import com.illichso.repository.UserRepository;
import com.illichso.repository.impl.UserRepositoryJPA;
import com.illichso.service.UserService;
import com.illichso.service.impl.UserServiceImpl;

public class UserModule  extends AbstractModule {

    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserRepository.class).to(UserRepositoryJPA.class);
    }

}
