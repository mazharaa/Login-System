package com.azhar.LoginSystem.controller;

import com.azhar.LoginSystem.Service.UserService;
import com.azhar.LoginSystem.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class ApiUserController {
    private UserService userService;

    public ApiUserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }
}
