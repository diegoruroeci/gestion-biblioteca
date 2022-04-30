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

    public abstract List<User> consultUsers() throws PersistenceException;

    public abstract void registerResource(String nombre, String ubicacion, String tipo, int capacidad, int idInterno, String descripcion, boolean disponible) throws PersistenceException;

}
