package register;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;

public class RegisterServiceImpl implements RegisterService {
    @Inject
    private ReservationDAO reservationDAO;

    @Override
    public void reserveResource(Reservation reservationv) throws ParseException {
        try {
            reservationDAO.reserveResource(reservationv);
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }

    }
}
