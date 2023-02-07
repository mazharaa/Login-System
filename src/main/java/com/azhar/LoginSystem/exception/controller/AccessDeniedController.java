package com.azhar.LoginSystem.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessDeniedController {
    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {
        return "Access Denied!";
    }
}
