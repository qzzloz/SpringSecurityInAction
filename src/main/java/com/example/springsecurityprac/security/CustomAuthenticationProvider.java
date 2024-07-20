package com.example.springsecurityprac.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if("john".equals(username) && "12345".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        }else{
            throw new AuthenticationCredentialsNotFoundException("Error in authentication");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }

}
