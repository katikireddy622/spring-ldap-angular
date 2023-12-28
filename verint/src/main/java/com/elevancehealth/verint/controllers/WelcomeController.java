package com.elevancehealth.verint.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class WelcomeController {

    @GetMapping("/")
    public String rootMessage(){
        return "Hey!!!";
    }

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to verint";
    }
}
