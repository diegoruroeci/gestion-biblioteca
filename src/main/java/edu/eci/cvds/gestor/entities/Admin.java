package edu.eci.cvds.gestor.entities;

public class Admin extends User{
    public Admin(String name, String email, String password, char role, int license) {
        super(name, email, password, role, license);
    }
}
