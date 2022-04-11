package edu.eci.cvds.gestor.entities;

public abstract class Resource {

    private String name;
    private String type;
    private int id;
    private String description;
    private Boolean available;
    private int internId;

    public Resource(String name, String type, int id, String description, Boolean available, int internId) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.description = description;
        this.available = available;
        this.internId = internId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public int getInternId() {
        return internId;
    }

    public void setInternId(int internId) {
        this.internId = internId;
    }
}
