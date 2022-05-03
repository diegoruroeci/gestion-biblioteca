package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.Reservation;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public interface ReservationDAO {

    public List<Reservation> consultReservations() throws ParseException;

    public void reserveResource(Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, String recurrence, Date recurrenceDate);

}
