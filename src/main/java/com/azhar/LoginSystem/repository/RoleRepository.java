package com.azhar.LoginSystem.repository;

import com.azhar.LoginSystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
