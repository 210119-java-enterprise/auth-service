package com.revature.auth.controllers;

import com.revature.auth.dto.Principal;
import com.revature.auth.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/token")
public class TokenController {

    private TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateTokenFromPrincipal(@RequestBody @Valid Principal principal) {
        return tokenService.generateToken(principal);
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public boolean validateToken(@RequestHeader("quizzard-token") String token) {
        return tokenService.isTokenValid(token);
    }

    @GetMapping(path = "/authorities")
    public String getTokenAuthorities(@RequestHeader("quizzard-token") String token) {
        return tokenService.getAuthorities(token);
    }

}
