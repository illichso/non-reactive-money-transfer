package com.illichso.repository;

import com.illichso.model.entity.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User findOne(int userId);

    void deleteAll();

    List<User> findAll();
}
