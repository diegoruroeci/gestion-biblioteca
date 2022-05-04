package edu.eci.cvds.gestor.services;

import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.entities.User;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public interface GestorServices {

    public abstract List<Resource> consultResources() throws PersistenceException;

    public abstract List<Reservation> consultReservations() throws PersistenceException;

    public abstract List<Reservation> consultReservations(int id) throws PersistenceException;

    public abstract List<Reservation> consultReservationsUser(String email) throws PersistenceException;

    public abstract List<Reservation> consultReservationsUserCancelled(String email) throws PersistenceException;

    public abstract List<Reservation> consultReservationsUserExpired(String email) throws PersistenceException;

    public abstract List<User> consultUsers() throws PersistenceException;

    public abstract List<Reservation> consultReservationsActive() throws PersistenceException;

    public abstract List<Reservation> consultReservationsCancelled() throws PersistenceException;

    public abstract List<Reservation> consultReservationsExpired() throws PersistenceException;

    public abstract void registerResource(int id, String nombre, String ubicacion, String tipo, int capacidad, int idInterno, String descripcion, boolean disponible) throws PersistenceException;

    public abstract List<Resource> getResources();

    public abstract void setResources(List<Resource> resources);

}
