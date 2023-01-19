package com.azhar.LoginSystem.controller;

import com.azhar.LoginSystem.Service.RoleService;
import com.azhar.LoginSystem.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class ApiRoleController {
    private RoleService roleService;

    public ApiRoleController (RoleService roleService) {
        super();
        this.roleService = roleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        return new ResponseEntity<Role>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable("id") Long id) {
        return new ResponseEntity<Role>(roleService.updateRole(role, id), HttpStatus.OK);
    }
}
