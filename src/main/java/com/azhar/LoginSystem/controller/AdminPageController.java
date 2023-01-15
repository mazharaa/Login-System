package com.azhar.LoginSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminPageController {
    @GetMapping("/admin")
    public String getUserPage() {
        return"Welcome to Admin Page!";
    }
}
