package com.azhar.LoginSystem.Service;

import com.azhar.LoginSystem.model.Privilege;

import java.util.List;

public interface PrivilegeService {
    List<Privilege> getAllPrivileges();
    Privilege getPrivilegeById(Long id);
    Privilege savePrivilege(Privilege privilege);
    Privilege updatePrivilege(Privilege privilege, Long id);
}
