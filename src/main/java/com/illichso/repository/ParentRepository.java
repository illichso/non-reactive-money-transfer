package com.illichso.repository;

import com.google.inject.Provider;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class ParentRepository {
    @Inject
    private final Provider<EntityManager> entityManagerProvider;

    public ParentRepository(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    protected EntityManager getEntityManager(){
        return entityManagerProvider.get();
    }
}
