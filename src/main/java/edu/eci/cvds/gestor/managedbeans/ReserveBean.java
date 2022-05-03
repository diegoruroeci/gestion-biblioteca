package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.services.ReserveServices;
import edu.eci.cvds.gestor.services.ServicesException;
import org.apache.ibatis.exceptions.PersistenceException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name="ReserveBean")
@SessionScoped
public class ReserveBean extends BasePageBean{

    @Inject
    ReserveServices reserveServices;


    public void reserve(String initHour, String finalHour, String recurrence, Date recurrenceDate) throws ServicesException {

        try {
            reserveServices.reserveResource("2022/04/30", initHour, finalHour, getRecurso(), 2165184, recurrence, recurrenceDate);
        }catch (PersistenceException persistenceException){
            throw new ServicesException("no se pudo completar la reserva", persistenceException);
        }
    }

    public int getRecurso() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        return Integer.parseInt(request.getParameter("recurso"));
    }

}
