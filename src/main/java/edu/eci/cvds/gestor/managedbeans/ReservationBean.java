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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
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

    private java.util.Date ini;
    private java.util.Date fin;

    private String currentDay;

    public void loadEvents(int recurso) {
        eventModel = new DefaultScheduleModel();
        List<Reservation> horarios = gestorServices.consultReservation(recurso);
        for (Reservation r : horarios){
            event = new DefaultScheduleEvent("Reservado", r.getStartHour(), r.getFinishHour());
            eventModel.addEvent(event);
            eventId = recurso;
            ini = r.getStartHour();
            fin = r.getFinishHour();
//            event.setId(String.valueOf(r.getId()));
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
//        this.eventId = Integer.parseInt(event.getId());
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

    public void onDateSelect(SelectEvent selectEvent) {
        java.util.Date date = (java.util.Date) selectEvent.getObject();
        java.util.Date datet = new java.util.Date(date.getTime() + (1000 * 60 * 60 * 24));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        this.currentDay = format.format(datet);

    }

    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public int getEventId() {
        return eventId;
    }

    public java.util.Date getIni() {
        return ini;
    }

    public java.util.Date getFin() {
        return fin;
    }

    public int setEventId() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        return Integer.parseInt(request.getParameter("id"));
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public List<Reservation> consultarRecursosMasUsados() {
        List<Reservation> recurso = new ArrayList<>();
        try {
            recurso = gestorServices.consultarRecursosMasUsados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;
    }

    public List<Reservation> consultarRecursosMenosUsados() {
        List<Reservation> recurso = new ArrayList<>();
        try {
            recurso = gestorServices.consultarRecursosMenosUsados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recurso;
    }
}
