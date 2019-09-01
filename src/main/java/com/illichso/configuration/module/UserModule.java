package com.illichso.configuration.module;

import com.google.inject.AbstractModule;
import com.illichso.configuration.UserServletModule;
import com.illichso.repository.UserRepository;
import com.illichso.repository.impl.UserRepositoryJPA;
import com.illichso.rest.UserController;
import com.illichso.service.UserService;
import com.illichso.service.impl.UserServiceImpl;

import static com.google.inject.Scopes.SINGLETON;

public class UserModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class).in(SINGLETON);
        bind(UserRepository.class).to(UserRepositoryJPA.class).in(SINGLETON);
//        bind(EntityManager.class).to(EntityManager.class).in(SINGLETON);

        bind(UserController.class);
        bind(UserServiceImpl.class);

        install(new UserServletModule());
    }
}