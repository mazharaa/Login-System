package com.azhar.LoginSystem.repository;

import com.azhar.LoginSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUser(String user);
}
