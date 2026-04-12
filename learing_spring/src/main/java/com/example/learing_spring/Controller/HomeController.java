package com.example.learing_spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("/")
    public String home(){
        return "<h2>Home page was found now . This page is done.ss/h2>";
    }
}
