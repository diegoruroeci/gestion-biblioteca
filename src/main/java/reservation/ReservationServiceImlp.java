package reservation;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public class ReservationServiceImlp implements ReservationService {
    @Inject
    private ReservationDAO reservationDAO;



    @Override
    public List<Reservation> consultReservations() throws PersistenceException {
        try{
            return reservationDAO.consultReservations();
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void reserveResource(Reservation reservationv) throws ParseException {
        try {
            reservationDAO.reserveResource(reservationv);
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }

    }
}
