package edu.eci.cvds.gestor.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.persistence.*;
import edu.eci.cvds.gestor.services.GestorServices;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;


@Singleton
public class GestorServicesImpl implements GestorServices {

//    @Inject
//    private AdminDAO adminDAO;
//
//    @Inject
//    private BoardDAO boardDAO;
//
//    @Inject
//    private BookDAO bookDAO;
//
//    @Inject
//    private CommunityDAO communityDAO;
//
//    @Inject
//    private ComputerDAO computerDAO;

    @Inject
    private ReservationDAO reservationDAO;

//    @Inject
//    private RoomDAO roomDAO;

    @Inject
    private ResourceDAO resourceDAO;

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
}
