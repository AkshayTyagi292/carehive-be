package com.carehive.security;

import com.carehive.entities.User;

public class AuthResponse {
    private String token;
    private User user; // User information will be included here

    public AuthResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
