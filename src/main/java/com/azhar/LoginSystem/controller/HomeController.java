package com.azhar.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping
    public ModelAndView index(Model model) {
        ModelAndView view = new ModelAndView("index");
        String messages = "Welcome to Login Page!";
        model.addAttribute("msg", messages);

        return view;
    }
}
