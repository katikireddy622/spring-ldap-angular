package com.elevancehealth.verint.configuration;

import com.elevancehealth.verint.services.CustomAuthenticationService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomAuthenticationService customAuthenticationService;

    public CustomAuthenticationProvider(CustomAuthenticationService customAuthenticationService) {
        this.customAuthenticationService = customAuthenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Use your CustomAuthenticationService to authenticate the user
        if (customAuthenticationService.authenticateUser(username, password)) {
            UserDetails userDetails = new UserDetails() {
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    // Retrieve the authorities based on user roles
                    // You can return a list of SimpleGrantedAuthority objects
                    return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }

                @Override
                public String getPassword() {
                    return password;
                }

                @Override
                public String getUsername() {
                    return username;
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
