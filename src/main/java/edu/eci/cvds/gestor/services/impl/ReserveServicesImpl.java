package edu.eci.cvds.gestor.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import edu.eci.cvds.gestor.services.GestorServices;
import edu.eci.cvds.gestor.services.ReserveServices;
import edu.eci.cvds.gestor.services.ServicesException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class ReserveServicesImpl implements ReserveServices {

    @Inject
    ReservationDAO reservationDAO;

    @Inject
    GestorServices gestorServices;

    @Override
    public void reserveResource(String date, String initHour, String finalHour, int resource, int carnet, String recurrence, Date recurrenceDate) throws ServicesException {
        try {
            Date dateFormatted = new SimpleDateFormat("yyyy/MM/dd").parse(date);
            java.sql.Date dateSql = new java.sql.Date(dateFormatted.getTime());
            java.sql.Date recurrenceDateSql = new java.sql.Date(recurrenceDate.getTime());
            Timestamp initTimeStamp = convertToTimestamp(date+' '+initHour);
            Timestamp finalTimeStamp = convertToTimestamp(date+' '+finalHour);
            reservationDAO.reserveResource(dateSql,initTimeStamp,finalTimeStamp,getResource(resource),carnet,recurrence,recurrenceDateSql);
        }catch (ParseException parseException){
            throw new ServicesException("La cadena no parece una fecha", parseException);
        }
    }

    private Timestamp convertToTimestamp(String time) throws ParseException {
        Date timeFormatted = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(time);
        Timestamp timeStamp = new Timestamp(timeFormatted.getTime());
        return timeStamp;
    }

    public int getResource(int index){
        List<Resource> resources = gestorServices.getResources();
        return resources.get(index).getId();
    }
}
