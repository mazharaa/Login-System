package com.azhar.LoginSystem.Service.impl;

import com.azhar.LoginSystem.Service.RoleService;
import com.azhar.LoginSystem.dto.UpdateNewPrivilegesDTO;
import com.azhar.LoginSystem.exception.ResourceNotFoundException;
import com.azhar.LoginSystem.model.Privilege;
import com.azhar.LoginSystem.model.Role;
import com.azhar.LoginSystem.repository.PrivilegeRepository;
import com.azhar.LoginSystem.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;

    public RoleServiceImpl(RoleRepository roleRepository, PrivilegeRepository privilegeRepository) {
        super();
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "Id", id));
    }

    @Override
    public Collection<Privilege> getPrivilegesRoleByRoleId(Long id) {
        return roleRepository.findById(id).get().getPrivileges();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role, Long id) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role", "Id", id));

        existingRole.setName(role.getName());
        existingRole.setPrivileges(role.getPrivileges());

        return roleRepository.save(existingRole);
    }

    @Override
    public Role updateRolePrivileges(UpdateNewPrivilegesDTO updateNewPrivilegesDTO) {
        Role existingRole = roleRepository.findById(updateNewPrivilegesDTO.getRoleId()).orElseThrow(() ->
                new ResourceNotFoundException("Role", "Id", updateNewPrivilegesDTO.getRoleId()));

        Collection<Privilege> newRolePrivileges = new ArrayList<>();

        for (Long i : updateNewPrivilegesDTO.getPrivilegesId()) {
            newRolePrivileges.add(privilegeRepository.findById(i).get());
        }

        existingRole.setPrivileges(newRolePrivileges);

        return roleRepository.save(existingRole);
    }
}
