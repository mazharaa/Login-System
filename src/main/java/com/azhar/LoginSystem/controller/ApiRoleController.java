package com.azhar.LoginSystem.controller;

import com.azhar.LoginSystem.Service.PrivilegeService;
import com.azhar.LoginSystem.Service.RoleService;
import com.azhar.LoginSystem.model.Privilege;
import com.azhar.LoginSystem.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class ApiRoleController {
    private RoleService roleService;
    private PrivilegeService privilegeService;

    public ApiRoleController (RoleService roleService, PrivilegeService privilegeService) {
        super();
        this.roleService = roleService;
        this.privilegeService = privilegeService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        return new ResponseEntity<Role>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/privilege")
    public Collection<Privilege> getPrivilegesRoleByRoleId(@PathVariable("id") Long id) {
        return roleService.getPrivilegesRoleByRoleId(id);
    }

    @PutMapping("/{roleId}/privilege")
    public ResponseEntity<Role> updateRolePrivileges(
            @PathVariable("roleId") Long roleId, @RequestBody List<Long> privilegesId
    ) {
        return new ResponseEntity<Role>(roleService.updateRolePrivileges(roleId, privilegesId),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable("id") Long id) {
        return new ResponseEntity<Role>(roleService.updateRole(role, id), HttpStatus.OK);
    }
}
