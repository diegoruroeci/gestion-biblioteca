package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.Reservation;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public interface ReservationDAO {

    public List<Reservation> consultReservations() throws ParseException;

    public List<Reservation> consultReservationsUser(String email) throws PersistenceException;

    public List<Reservation> consultReservationsUserCancelled(String email) throws PersistenceException;

    public List<Reservation> consultReservationsUserExpired(String email) throws PersistenceException;

    public List<Reservation> consultReservationsActive() throws PersistenceException;

    public List<Reservation> consultReservationsCancelled() throws PersistenceException;

    public List<Reservation> consultReservationsExpired() throws PersistenceException;
}
