package com.azhar.LoginSystem.Service;

import com.azhar.LoginSystem.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(User user, Long id);
}
