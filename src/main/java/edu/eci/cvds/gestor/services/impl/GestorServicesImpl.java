package edu.eci.cvds.gestor.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.entities.User;
import edu.eci.cvds.gestor.persistence.*;
import edu.eci.cvds.gestor.services.GestorServices;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;


@Singleton
public class GestorServicesImpl implements GestorServices {


    @Inject
    private ReservationDAO reservationDAO;

    @Inject
    private ResourceDAO resourceDAO;

    @Inject
    private UserDAO userDAO;

    @Override
    public List<Resource> consultResources() throws PersistenceException {
        try{
            return resourceDAO.consultResources();
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservations() throws PersistenceException {
        try{
            return reservationDAO.consultReservations();
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<User> consultUsers() throws PersistenceException {
        try {
            return userDAO.consultUsers();
        } catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    public void registerResource( int id, String nombre, String ubicacion, String tipo, int capacidad, int idInterno, String descripcion, boolean disponible) throws PersistenceException {
        try {
            resourceDAO.registerResource( id, nombre, ubicacion, tipo, capacidad, idInterno, descripcion, disponible);
        }catch (PersistenceException | ParseException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}

