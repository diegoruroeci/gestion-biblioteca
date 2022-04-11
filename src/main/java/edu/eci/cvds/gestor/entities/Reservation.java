package edu.eci.cvds.gestor.entities;

import java.util.Date;

public class Reservation {

    private int id;
    private Date date;
    private String startHour;
    private String finishHour;
    private Resource resource;
    private int license;

    public Reservation(int id, Date date, String startHour, String finishHour, Resource resource, int license) {
        this.id = id;
        this.date = date;
        this.startHour = startHour;
        this.finishHour = finishHour;
        this.resource = resource;
        this.license = license;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(String finishHour) {
        this.finishHour = finishHour;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }
}
