package edu.eci.cvds.gestor.entities;

public class Room extends Resource{
    public Room(String name, String type, int id, String description, Boolean available, int internId) {
        super(name, type, id, description, available, internId);
    }
}
