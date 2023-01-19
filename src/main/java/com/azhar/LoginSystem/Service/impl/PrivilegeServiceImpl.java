package com.azhar.LoginSystem.Service.impl;

import com.azhar.LoginSystem.Service.PrivilegeService;
import com.azhar.LoginSystem.exception.ResourceNotFoundException;
import com.azhar.LoginSystem.model.Privilege;
import com.azhar.LoginSystem.repository.PrivilegeRepository;

public class PrivilegeServiceImpl implements PrivilegeService {
    private PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        super();
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege getPrivilegeById(Long id) {
        return privilegeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Privilege", "Id", id));
    }

    @Override
    public Privilege savePrivilege(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    @Override
    public Privilege updatePrivilege(Privilege privilege, Long id) {
        Privilege exisitingPrivilege = getPrivilegeById(id);

        exisitingPrivilege.setName(privilege.getName());
        exisitingPrivilege.setRoles(privilege.getRoles());

        return privilegeRepository.save(exisitingPrivilege);
    }
}
