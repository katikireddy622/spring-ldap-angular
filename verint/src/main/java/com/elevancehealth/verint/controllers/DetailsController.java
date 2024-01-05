package com.elevancehealth.verint.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DetailsController {

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to verint";
    }
}
