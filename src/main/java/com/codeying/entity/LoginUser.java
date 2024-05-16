package com.codeying.entity;

/**
 * 标记为可登录用户
 */
public class LoginUser {

    private String id;
    private String username;
    private String password;
    private String role;
    private String rolech;

    public String getRolech() {
        return rolech;
    }

    public void setRolech(String rolech) {
        this.rolech = rolech;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
