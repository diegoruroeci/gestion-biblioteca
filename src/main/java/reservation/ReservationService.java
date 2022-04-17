package reservation;

import edu.eci.cvds.gestor.entities.Reservation;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public interface ReservationService {

    public abstract List<Reservation> consultReservations() throws PersistenceException;
    public abstract void reserveResource(Reservation reservationv) throws ParseException;
}
