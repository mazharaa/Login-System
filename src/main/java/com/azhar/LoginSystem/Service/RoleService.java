package com.azhar.LoginSystem.Service;

import com.azhar.LoginSystem.model.Role;

public interface RoleService {
    Role getRoleById(Long id);
    Role saveRole(Role role);
    Role updateRole(Role role, Long id);
}
