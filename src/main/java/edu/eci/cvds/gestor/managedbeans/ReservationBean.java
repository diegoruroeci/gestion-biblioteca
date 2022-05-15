package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;

import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.entities.User;
import edu.eci.cvds.gestor.services.GestorServices;
import edu.eci.cvds.gestor.services.ServicesException;
import edu.eci.cvds.gestor.services.UserServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@SuppressWarnings("deprecation")
@ManagedBean(name="ReservationBean")
@ApplicationScoped
public class ReservationBean extends BasePageBean{


    private Timestamp startHour;
    private Timestamp finishHour;
    private String recurrence;
    private Date recurrenceTime;


    @Inject
    private GestorServices gestorServices;

    @Inject
    private UserServices userServices;

    public List<Reservation> getReservations() {
        return gestorServices.consultReservations();
    }

    public List<Reservation> getReservationsUser(String email) {
        if (userServices.isAdmin()){
            return gestorServices.consultReservationsActive();
        }else {
            return gestorServices.consultReservationsUser(email);
        }
    }

    public List<Reservation> getReservationsUserCancelled(String email) {
        if (userServices.isAdmin()) {
            return gestorServices.consultReservationsCancelled();
        }else {
            return gestorServices.consultReservationsUserCancelled(email);
        }
    }

    public List<Reservation> getReservationsUserExpired(String email) {
        if (userServices.isAdmin()) {
            return gestorServices.consultReservationsExpired();
        }else {
            return gestorServices.consultReservationsUserExpired(email);
        }
    }

    public Timestamp getStartHour() {
        return startHour;
    }

    public Timestamp getFinishHour() {
        return finishHour;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public Date getRecurrenceTime() {
        return recurrenceTime;
    }



    //Schedule

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    private int eventId;

    public void loadEvents(int recurso) {
        eventModel = new DefaultScheduleModel();
        List<Reservation> horarios = gestorServices.consultReservation(recurso);
        for (Reservation r : horarios){
            event = new DefaultScheduleEvent("2" + " - " + "2", r.getStartHour(), r.getFinishHour());
            eventModel.addEvent(event);
            event.setId(String.valueOf(r.getId()));
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public void onDateSelect(){

    }

    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public int getEventId() {
        return eventId;
    }

    public int setEventId() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        return Integer.parseInt(request.getParameter("id"));
    }


}
