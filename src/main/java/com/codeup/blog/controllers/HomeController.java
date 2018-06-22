package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/hello/{name}")
    public String welcome(Model model, @PathVariable String name) {
        model.addAttribute("name",name);
        return "home";
    }
}