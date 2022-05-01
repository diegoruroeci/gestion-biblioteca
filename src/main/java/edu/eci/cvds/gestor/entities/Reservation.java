package edu.eci.cvds.gestor.entities;

import java.io.Serializable;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class Reservation implements Serializable {

    private int id;
    private Date date;
    private Timestamp startHour;
    private Timestamp finishHour;
    private int resource;
    private int license;
    private Resource resources;
    private User Uname;

    public Reservation(){
        super();
    }

    public Reservation(int id, Date date, Timestamp startHour, Timestamp finishHour, int resource, int license) {
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

    public Timestamp getStartHour() {
        return startHour;
    }

    public void setStartHour(Timestamp startHour) {
        this.startHour = startHour;
    }

    public Timestamp getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(Timestamp finishHour) {
        this.finishHour = finishHour;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public Resource getResources() {
        return resources;
    }

    public void setResources(Resource resources) {
        this.resources = resources;
    }

    public User getUname() {
        return Uname;
    }

    public void setUname(User uname) {
        Uname = uname;
    }

    @Override
    public String toString(){
        return "Review{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", startHour=" + startHour + '\'' +
                ", finishHour='" + finishHour + '\'' +
                ", resource=" + resource + '\'' +
                ", license=" + license+
                '}';
    }
}
