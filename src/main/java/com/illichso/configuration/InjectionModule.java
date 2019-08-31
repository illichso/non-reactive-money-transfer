package com.illichso.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.illichso.repository.AccountRepository;
import com.illichso.repository.UserRepository;
import com.illichso.repository.impl.AccountRepositoryJPA;
import com.illichso.repository.impl.UserRepositoryJPA;
import com.illichso.service.AccountService;
import com.illichso.service.UserService;
import com.illichso.service.impl.AccountServiceImpl;
import com.illichso.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class InjectionModule extends AbstractModule {
    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<EntityManager>();

    @Provides
    @Singleton
    public EntityManagerFactory provideEntityManagerFactory() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:mem:money");
        properties.put("hibernate.connection.username", "");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.connection.pool_size", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.show_sql", "true");
        return Persistence.createEntityManagerFactory("db-manager", properties);
    }

    @Provides
    public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
        if (entityManager == null) {
            ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory.createEntityManager());
        }
        return entityManager;
    }

    @Override
    protected void configure() {
        configureServiceInjections();
        configureRepositoryInjections();
    }

    private void configureServiceInjections() {
        bind(AccountService.class).to(AccountServiceImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
    }

    private void configureRepositoryInjections() {
        bind(AccountRepository.class).to(AccountRepositoryJPA.class);
        bind(UserRepository.class).to(UserRepositoryJPA.class);
    }
}