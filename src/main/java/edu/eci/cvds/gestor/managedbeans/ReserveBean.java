package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.services.RecurrenceOptions;
import edu.eci.cvds.gestor.services.ReserveServices;
import edu.eci.cvds.gestor.services.ServicesException;
import edu.eci.cvds.gestor.services.UserServices;
import org.apache.ibatis.exceptions.PersistenceException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name="ReserveBean")
@SessionScoped
public class ReserveBean extends BasePageBean{

    @Inject
    ReserveServices reserveServices;

    @Inject
    UserServices userServices;


    public void reserve(String initHour, String finalHour, String recurrence, Date recurrenceDate) throws ServicesException {

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            reserveServices.reserveResource(dtf.format(LocalDate.now()), initHour, finalHour, getRecurso(), userServices.getCarnetByEmail(userServices.getEmail()), getRecurrenceOptions(recurrence), recurrenceDate);
        }catch (PersistenceException persistenceException){
            throw new ServicesException("no se pudo completar la reserva", persistenceException);
        }
    }

    public int getRecurso() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        return Integer.parseInt(request.getParameter("recurso"));
    }

    public RecurrenceOptions getRecurrenceOptions(String recurrence){
        switch (recurrence){
            case "oneTime":
                return RecurrenceOptions.ONE_TIME;
            case "diaria":
                return RecurrenceOptions.DAILY;
            case "semanal":
                return RecurrenceOptions.WEEKLY;
            case "mensual":
                return RecurrenceOptions.MONTHLY;
        }
        return null;
    }
}
