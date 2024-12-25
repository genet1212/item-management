package com.backend.dtoes;

import com.backend.model.Role;

import java.util.List;
import java.util.Set;

public class RegisterResponse {
    private String userName;
    private String email;
    private Set<Role> roles;

    public RegisterResponse(String userName, String email, Set<Role> roles) {
        this.userName = userName;
        this.email = email;
        this.roles = roles;
    }


    public String getuserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
