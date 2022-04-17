package consult;

import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.entities.Resource;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface ConsultService {

    public abstract List<Resource> consultResources() throws PersistenceException;

    public abstract List<Reservation> consultReservations() throws PersistenceException;
}
