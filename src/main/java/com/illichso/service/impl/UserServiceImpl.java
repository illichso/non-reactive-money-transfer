package com.illichso.service.impl;

import com.illichso.model.entity.User;
import com.illichso.repository.UserRepository;
import com.illichso.service.UserService;

import javax.inject.Inject;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String userName) {
        User user = new User(userName);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
