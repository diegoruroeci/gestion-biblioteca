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

    private List<Resource> resources;

    @Override
    public List<Resource> consultResources() throws PersistenceException {
        try{
            List<Resource> resources = resourceDAO.consultResources();
            setResources(resources);
            return resources;
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

    public List<Reservation> consultReservations(int id) throws PersistenceException {
        try{
            return reservationDAO.consultReservations(id);
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsUser(String email) throws PersistenceException {
        try{
            return reservationDAO.consultReservationsUser(email);
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsUserCancelled(String email) throws PersistenceException {
        try{
            return reservationDAO.consultReservationsUserCancelled(email);
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsUserExpired(String email) throws PersistenceException {
        try{
            return reservationDAO.consultReservationsUserExpired(email);
        }catch (PersistenceException e) {
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

    @Override
    public List<Reservation> consultReservationsActive() throws PersistenceException {
        try{
            return reservationDAO.consultReservationsActive();
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsCancelled() throws PersistenceException {
        try{
            return reservationDAO.consultReservationsCancelled();
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsExpired() throws PersistenceException {
        try{
            return reservationDAO.consultReservationsExpired();
        }catch (PersistenceException e) {
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}

