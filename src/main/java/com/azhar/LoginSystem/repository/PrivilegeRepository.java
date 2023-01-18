package com.azhar.LoginSystem.repository;

import com.azhar.LoginSystem.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    List<Privilege> findByPrivilege(String privilege);
}
