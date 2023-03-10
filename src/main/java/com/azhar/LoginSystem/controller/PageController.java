package com.azhar.LoginSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @GetMapping
    public ModelAndView index(Model model) {
        ModelAndView view = new ModelAndView("login");
        String messages = "Welcome to Login Page!";
        model.addAttribute("msg", messages);

        return view;
    }

    @GetMapping("/login/index")
    public ModelAndView login(Model model) {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @GetMapping("/home/index")
    public ModelAndView home(Model model) {
        ModelAndView view = new ModelAndView("home");
        return view;
    }

    @GetMapping("/register/index")
    public ModelAndView register(Model model) {
        ModelAndView view = new ModelAndView("register");
        return view;
    }
}
