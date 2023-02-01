package com.azhar.LoginSystem.dto;

import com.azhar.LoginSystem.model.Role;

import java.util.List;

public class UpdateNewPrivilegesDTO {
    private Role role;
    private Long roleId;
    private List<Long> privilegesId;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getPrivilegesId() {
        return privilegesId;
    }

    public void setPrivilegesId(List<Long> privilegesId) {
        this.privilegesId = privilegesId;
    }
}
