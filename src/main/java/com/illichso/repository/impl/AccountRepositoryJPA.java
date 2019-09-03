package com.illichso.repository.impl;

import com.google.inject.Provider;
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

    @Inject
    private Provider<EntityManager> entityManager;

    public AccountRepositoryJPA() {
    }
    public Account save(Account account) {
        entityManager.get().getTransaction().begin();
        entityManager.get().persist(account);
        entityManager.get().getTransaction().commit();
        return account;
    }

    public Account findOne(int accountId) {
        TypedQuery<Account> query = entityManager.get().createQuery(
                "SELECT u FROM Account u WHERE u.id = :accountId",
                Account.class);
        query.setParameter("accountId", accountId);
        return query.getSingleResult();
    }

    public void deleteAll() {
        entityManager.get().getTransaction().begin();
        Query query = entityManager.get().createQuery(
                "DELETE FROM Account");
        query.executeUpdate();
        entityManager.get().getTransaction().commit();
    }

    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.get().createQuery(
                "SELECT u FROM Account u",
                Account.class);
        return query.getResultList();
    }

}
