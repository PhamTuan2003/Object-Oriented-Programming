package com.vds.huylq33.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCController {

    @RequestMapping("/greet")
    public String index(Model model) {
        model.addAttribute("greet", "Greetings from Spring Boot!");
        return "welcome";
    }
}


