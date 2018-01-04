package com.illichso.repository;

import com.illichso.model.User;

import java.util.List;

public interface UserRepository {

    long save(User user);

    User findOne(int userId);

    void deleteAll();

    List<User> findAll();
}
