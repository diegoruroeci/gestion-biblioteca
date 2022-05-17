package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.services.RecurrenceOptions;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public interface ReservationDAO {

    public List<Reservation> consultReservations() throws ParseException;
  
    public List<Reservation> consultReservation(int id) throws ParseException;

    public void reserveResource(Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, RecurrenceOptions recurrence, Date recurrenceDate,String status);

    public List<Reservation> consultReservationsUser(String email) throws PersistenceException;

    public List<Reservation> consultReservationsUserCancelled(String email) throws PersistenceException;

    public List<Reservation> consultReservationsUserExpired(String email) throws PersistenceException;

    public List<Reservation> consultReservationsActive() throws PersistenceException;

    public List<Reservation> consultReservationsActiveByHour(Timestamp initHour,Timestamp finalHour,int resource) throws PersistenceException;

    public List<Reservation> consultReservationsCancelled() throws PersistenceException;

    public List<Reservation> consultReservationsExpired() throws PersistenceException;

    public List<Reservation> recursosMasUsados() throws PersistenceException;

    public List<Reservation> recursosMenosUsados() throws PersistenceException;

    public List<Reservation> reservaPorCarrera() throws PersistenceException;

}
