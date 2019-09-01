package com.illichso.repository.impl;

import com.illichso.model.entity.Account;
import com.illichso.repository.AccountRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class AccountRepositoryJPA implements AccountRepository {

    private EntityManager entityManager;

    @Inject
    public AccountRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Account save(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account;
    }

    public Account findOne(int accountId) {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT u FROM Account u WHERE u.id = :accountId",
                Account.class);
        query.setParameter("accountId", accountId);
        return query.getSingleResult();
    }

    public void deleteAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "DELETE FROM Account");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT u FROM Account u",
                Account.class);
        return query.getResultList();
    }

}
