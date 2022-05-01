package edu.eci.cvds.gestor.services;

import java.text.ParseException;

public interface ReserveServices {

    public void reserveResource(String date,String initHour, String finalHour, int resource, int carnet, String recurrence) throws ServicesException;

}
