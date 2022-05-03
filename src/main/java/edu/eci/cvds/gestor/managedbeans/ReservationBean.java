package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;

import edu.eci.cvds.gestor.services.GestorServices;
import edu.eci.cvds.gestor.services.UserServices;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="ReservationBean")
@ApplicationScoped
public class ReservationBean extends BasePageBean{

    @Inject
    private GestorServices gestorServices;

    @Inject
    private UserServices userServices;

    public List<Reservation> getReservations() {
        return gestorServices.consultReservations();
    }

    public List<Reservation> getReservationsUser(String email) {
        return gestorServices.consultReservationsUser(email);
    }

    public List<Reservation> getAllReservations() {return gestorServices.consultAllReservations();}

}
