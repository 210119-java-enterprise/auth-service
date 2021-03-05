package com.revature.auth.util;

import com.revature.auth.dto.Principal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private JwtConfig config;

    @Autowired
    public JwtValidator(JwtConfig config) {
        this.config = config;
    }

    public Principal parseToken(String token) {

        Claims claims = Jwts.parser()
                            .setSigningKey(config.getSigningKey())
                            .parseClaimsJws(token)
                            .getBody();

        int id = Integer.parseInt(claims.getId());
        String username = claims.getSubject();
        String role = claims.get("role", String.class);
        return new Principal(id, username, role);

    }

}
