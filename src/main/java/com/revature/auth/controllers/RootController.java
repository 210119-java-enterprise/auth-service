package com.revature.auth.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String root() {
        return "{\n\tstatus: up\n}";
    }

}
