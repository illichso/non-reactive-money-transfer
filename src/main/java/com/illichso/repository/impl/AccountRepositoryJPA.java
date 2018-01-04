package com.illichso.repository.impl;

import com.illichso.model.Account;
import com.illichso.repository.AccountRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class AccountRepositoryJPA implements AccountRepository {

    private EntityManager entityManager;

    public AccountRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long save(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account.getId();
    }

    public Account findOne(int accountId) {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT u FROM Account u WHERE u.id = :accountId",
                Account.class);
        query.setParameter("accountId", accountId);
        return query.getSingleResult();
    }

    public void deleteAll() {
        Query query = entityManager.createQuery(
                "DELETE FROM Account");
        query.executeUpdate();
    }

    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT u FROM Account u",
                Account.class);
        return query.getResultList();
    }

}
