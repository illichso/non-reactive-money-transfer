package com.illichso.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import static javax.persistence.Persistence.createEntityManagerFactory;

class TestDBUtil {
    private static final String UNIT_NAME = "test";
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    static EntityManager getEntityManager() {
        if (entityManager == null) {
            initTests();
        }
        return entityManager;
    }

    private static void initTests() {
        initEntityManagerFactory();
        initEntityManager();
    }


    private static void initEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            initEntityManagerFactory();
            try {
                entityManager = factory.createEntityManager();
            } catch (PersistenceException e) {
                System.exit(1);
            }
        }
    }

    private static void initEntityManagerFactory() {
        if (factory == null) {
            initFactory();
        }
    }

    private static void initFactory() {
        factory = createEntityManagerFactory(UNIT_NAME);
    }
}
