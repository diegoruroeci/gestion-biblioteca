package edu.eci.cvds.gestor.entities;

public class Computer extends Resource{
    public Computer(String name, String type, int id, String description, Boolean available, int internId) {
        super(name, type, id, description, available, internId);
    }
}
