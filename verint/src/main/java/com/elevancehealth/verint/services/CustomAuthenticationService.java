package com.elevancehealth.verint.services;

import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationService {

    public boolean authenticateUser(String username, String password) {
        // Your custom authentication logic goes here
        // For example, check credentials against a database or other data source
        return "ben".equals(username) && "a8032121".equals(password);
    }
}
