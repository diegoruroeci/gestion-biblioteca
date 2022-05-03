package edu.eci.cvds.gestor.services;

import java.text.ParseException;
import java.util.Date;

public interface ReserveServices {

    public void reserveResource(String date,String initHour, String finalHour, int resource, int carnet, String recurrence, Date recurrenceDate) throws ServicesException;

}
