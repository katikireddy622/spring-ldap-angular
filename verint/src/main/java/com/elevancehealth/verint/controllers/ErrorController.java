package com.elevancehealth.verint.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/error")
    public String errorMessage(){
        return "user credentials are wrong";
    }
}
