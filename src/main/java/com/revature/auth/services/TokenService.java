package com.revature.auth.services;

import com.revature.auth.dto.Principal;
import com.revature.auth.util.JwtGenerator;
import com.revature.auth.util.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private JwtGenerator tokenGenerator;
    private JwtValidator tokenValidator;

    @Autowired
    public TokenService(JwtGenerator tokenGenerator, JwtValidator tokenValidator) {
        this.tokenGenerator = tokenGenerator;
        this.tokenValidator = tokenValidator;
    }

    public String generateToken(Principal subject) {
        return tokenGenerator.createToken(subject);
    }

    public boolean isTokenValid(String token) {
        Principal principal = tokenValidator.parseToken(token);
        return principal != null;
    }

    public String getAuthorities(String token) {
        Principal principal = tokenValidator.parseToken(token);

        if (principal == null) {
            throw new RuntimeException("Principal within token was null!");
        }

        return principal.getRole();

    }
}
