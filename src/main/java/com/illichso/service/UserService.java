package com.illichso.service;

import com.illichso.model.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(String userName);

    List<User> getAllUsers();

}
