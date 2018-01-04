package com.illichso.repository.impl;

import com.illichso.model.User;
import com.illichso.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class UserRepositoryJPA implements UserRepository {

    private EntityManager entityManager;

    public UserRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public long save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user.getId();
    }

    public User findOne(int userId) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id = :userId",
                User.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    public void deleteAll() {
        Query query = entityManager.createQuery(
                "DELETE FROM User u");
        query.executeUpdate();
    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u",
                User.class);
        return query.getResultList();
    }

}
