package com.azhar.LoginSystem.Service;

import com.azhar.LoginSystem.model.Privilege;

public interface PrivilegeService {
    Privilege getPrivilegeById(Long id);
    Privilege savePrivilege(Privilege privilege);
    Privilege updatePrivilege(Privilege privilege, Long id);
}
