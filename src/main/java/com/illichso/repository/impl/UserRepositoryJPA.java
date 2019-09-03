package com.illichso.repository.impl;

import com.google.inject.Provider;
import com.illichso.model.entity.User;
import com.illichso.repository.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class UserRepositoryJPA implements UserRepository {

    @Inject
    private Provider<EntityManager> entityManager;

    public UserRepositoryJPA() {
    }

    public User save(User user) {
        entityManager.get().getTransaction().begin();
        entityManager.get().persist(user);
        entityManager.get().getTransaction().commit();
        return user;
    }

    public User findOne(int userId) {
        TypedQuery<User> query = entityManager.get().createQuery(
                "SELECT u FROM User u WHERE u.id = :userId",
                User.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    public void deleteAll() {
        entityManager.get().getTransaction().begin();

        Query query = entityManager.get().createQuery(
                "DELETE FROM User u");
        query.executeUpdate();

        entityManager.get().getTransaction().commit();

    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.get().createQuery(
                "SELECT u FROM User u",
                User.class);
        return query.getResultList();
    }

}
