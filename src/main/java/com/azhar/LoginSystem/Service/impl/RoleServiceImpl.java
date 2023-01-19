package com.azhar.LoginSystem.Service.impl;

import com.azhar.LoginSystem.Service.RoleService;
import com.azhar.LoginSystem.exception.ResourceNotFoundException;
import com.azhar.LoginSystem.model.Role;
import com.azhar.LoginSystem.repository.RoleRepository;

public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super();
        this.roleRepository = roleRepository;
    }
    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "Id", id));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role, Long id) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "Id", id));

        existingRole.setName(role.getName());
        existingRole.setPrivileges(role.getPrivileges());
        existingRole.setUsers(role.getUsers());

        return roleRepository.save(existingRole);
    }
}
