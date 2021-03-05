package com.revature.auth.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Principal {

    @Min(1)
    private int id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String role;

    public Principal() {
        super();
    }

    public Principal(@Min(1) int id, @NotEmpty String username, @NotEmpty String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
