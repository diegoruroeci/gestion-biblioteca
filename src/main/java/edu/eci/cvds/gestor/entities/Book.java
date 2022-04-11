package edu.eci.cvds.gestor.entities;

public class Book extends Resource{
    public Book(String name, String type, int id, String description, Boolean available, int internId) {
        super(name, type, id, description, available, internId);
    }
}
