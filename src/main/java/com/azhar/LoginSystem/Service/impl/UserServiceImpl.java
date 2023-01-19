package com.azhar.LoginSystem.Service.impl;

import com.azhar.LoginSystem.Service.UserService;
import com.azhar.LoginSystem.exception.ResourceNotFoundException;
import com.azhar.LoginSystem.model.User;
import com.azhar.LoginSystem.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User existinguser = getUserById(id);

        existinguser.setUsername(user.getUsername());
        existinguser.setPassword(user.getPassword());
        existinguser.setRole(user.getRole());

        return userRepository.save(existinguser);
    }
}
