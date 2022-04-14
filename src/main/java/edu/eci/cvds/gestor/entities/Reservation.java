package edu.eci.cvds.gestor.entities;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

    private int id;
    private String date;
    private String startHour;
    private String finishHour;
    private String  resource;
    private int license;

    public Reservation(int id, String date, String startHour, String finishHour, String resource, int license) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
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
