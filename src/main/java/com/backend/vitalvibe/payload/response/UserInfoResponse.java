package com.backend.vitalvibe.payload.response;

import java.util.List;

public class UserInfoResponse {

    private String id;
    private String username;
    private String email;
    private int themeColor;
    private List<String> role;

    public UserInfoResponse(String id, String username, String email, int themeColor, List<String> role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.themeColor = themeColor;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(int themeColor) {
        this.themeColor = themeColor;
    }
}
