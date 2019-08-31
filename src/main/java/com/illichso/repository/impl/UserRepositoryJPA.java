package com.illichso.repository.impl;

import com.illichso.model.User;
import com.illichso.repository.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class UserRepositoryJPA implements UserRepository {

    private EntityManager entityManager;

    @Inject
    public UserRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    public User findOne(int userId) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id = :userId",
                User.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    public void deleteAll() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "DELETE FROM User u");
        query.executeUpdate();

        entityManager.getTransaction().commit();

    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u",
                User.class);
        return query.getResultList();
    }

}
