package com.azhar.LoginSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPageController {
    @GetMapping("/user")
    public String getAdminPage() {
        return "Welcome to User  Page";
    }
}
