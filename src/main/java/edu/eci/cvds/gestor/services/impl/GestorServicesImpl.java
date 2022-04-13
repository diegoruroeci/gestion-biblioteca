package edu.eci.cvds.gestor.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.gestor.persistence.*;
import edu.eci.cvds.gestor.services.GestorServices;



@Singleton
public class GestorServicesImpl implements GestorServices {

    @Inject
    private AdminDAO adminDAO;

    @Inject
    private BoardDAO boardDAO;

    @Inject
    private BookDAO bookDAO;

    @Inject
    private CommunityDAO communityDAO;

    @Inject
    private ComputerDAO computerDAO;

    @Inject
    private ReservationDAO reservationDAO;

    @Inject
    private RoomDAO roomDAO;
}
