package com.simplesrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //@RequestMapping(value = "/home")
    @GetMapping("/api/login/test")
    public String home() {
        return "index";
    }
}
