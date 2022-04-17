package register;

import edu.eci.cvds.gestor.entities.Reservation;

import java.text.ParseException;

public interface RegisterService {

    public abstract void reserveResource(Reservation reservationv) throws ParseException;

}
