package edu.eci.cvds.gestor.services;

import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.entities.User;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface GestorServices {

    public abstract List<Resource> consultResources() throws PersistenceException;

    public abstract List<Reservation> consultReservations() throws PersistenceException;

    public abstract List<User> consultUsers() throws PersistenceException;
}
