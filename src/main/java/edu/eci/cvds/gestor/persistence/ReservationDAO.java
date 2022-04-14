package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.Reservation;

import java.text.ParseException;
import java.util.List;

public interface ReservationDAO {

    public List<Reservation> consultReservations() throws ParseException;

}
