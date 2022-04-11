package edu.eci.cvds.gestor.entities;

public abstract class User {
    private String name;
    private String email;
    private String password;
    private char role;
    private int license;

    public User(String name, String email, String password, char role, int license) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }
}
