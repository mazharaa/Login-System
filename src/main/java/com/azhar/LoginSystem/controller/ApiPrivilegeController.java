package com.azhar.LoginSystem.controller;

import com.azhar.LoginSystem.Service.PrivilegeService;
import com.azhar.LoginSystem.model.Privilege;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/privilege/")
public class ApiPrivilegeController {
    private PrivilegeService privilegeService;

    public ApiPrivilegeController(PrivilegeService privilegeService) {
        super();
        this.privilegeService = privilegeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Privilege> getPrivilegeById(@PathVariable("id") Long id) {
        return new ResponseEntity<Privilege>(privilegeService.getPrivilegeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Privilege> savePrivilege(@RequestBody Privilege privilege) {
        return new ResponseEntity<Privilege>(privilegeService.savePrivilege(privilege), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Privilege> updatePrivilege(@RequestBody Privilege privilege, @PathVariable("id") Long id) {
        return new ResponseEntity<Privilege>(privilegeService.updatePrivilege(privilege, id), HttpStatus.OK);
    }
}
