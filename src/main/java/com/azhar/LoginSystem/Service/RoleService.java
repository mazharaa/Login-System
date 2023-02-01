package com.azhar.LoginSystem.Service;

import com.azhar.LoginSystem.model.Privilege;
import com.azhar.LoginSystem.model.Role;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Collection<Privilege> getPrivilegesRoleByRoleId(Long id);
    Role saveRole(Role role);
    Role updateRole(Role role, Long id);
    Role updateRolePrivileges(Long roleId, List<Long> privilegesId);
}
