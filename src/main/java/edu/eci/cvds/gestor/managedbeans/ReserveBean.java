package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.services.ReserveServices;
import edu.eci.cvds.gestor.services.ServicesException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name="ReserveBean")
@SessionScoped
public class ReserveBean extends BasePageBean{

    @Inject
    ReserveServices reserveServices;


    public void reserve(String initHour, String finalHour, String recurrence) throws ServicesException {
        reserveServices.reserveResource("2022/04/30",initHour,finalHour,getRecurso(),2165184,recurrence);
    }

    public int getRecurso() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        return Integer.parseInt(request.getParameter("recurso"));
    }

}
