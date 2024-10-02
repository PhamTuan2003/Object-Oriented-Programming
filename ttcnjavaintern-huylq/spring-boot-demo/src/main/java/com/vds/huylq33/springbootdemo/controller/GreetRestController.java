package com.vds.huylq33.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

    @RequestMapping("/test")
    public String test() {
        return "Greetings from Spring Boot!";
    }
}
