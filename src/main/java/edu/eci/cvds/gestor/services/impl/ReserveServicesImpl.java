package edu.eci.cvds.gestor.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import edu.eci.cvds.gestor.services.GestorServices;
import edu.eci.cvds.gestor.services.RecurrenceOptions;
import edu.eci.cvds.gestor.services.ReserveServices;
import edu.eci.cvds.gestor.services.ServicesException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class ReserveServicesImpl implements ReserveServices {

    @Inject
    ReservationDAO reservationDAO;

    @Inject
    GestorServices gestorServices;

    @Override
    public void reserveResource(String date, String initHour, String finalHour, int resource, int carnet, RecurrenceOptions recurrence, Date recurrenceDate,String status) throws ServicesException {
        try {
            Date dateFormatted = new SimpleDateFormat("yyyy/MM/dd").parse(date);
            java.sql.Date dateSql = new java.sql.Date(dateFormatted.getTime());
            Timestamp initTimeStamp = convertToTimestamp(date+' '+initHour);
            Timestamp finalTimeStamp = convertToTimestamp(date+' '+finalHour);
            if (recurrence != RecurrenceOptions.ONE_TIME){
                java.sql.Date recurrenceDateSql = new java.sql.Date(recurrenceDate.getTime());
                createReservations(dateSql,initTimeStamp,finalTimeStamp,resource,carnet,recurrence,recurrenceDateSql,status);
            }else {
                reservationDAO.reserveResource(dateSql,initTimeStamp,finalTimeStamp,resource,carnet,recurrence,dateSql,status);
            }
        }catch (ParseException parseException){
            throw new ServicesException("La cadena no parece una fecha", parseException);
        }
    }

    private Timestamp convertToTimestamp(String time) throws ParseException {
        Date timeFormatted = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(time);
        Timestamp timeStamp = new Timestamp(timeFormatted.getTime());
        return timeStamp;
    }

    
    public void createReservations(java.sql.Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, RecurrenceOptions recurrence, java.sql.Date recurrenceDate,String status){
        switch (recurrence){
            case DAILY:
                createDailyReservations(date,initHour,finalHour,resource,carnet,recurrence,recurrenceDate,status);
                break;
            case WEEKLY:
                createWeeklyReservations(date,initHour,finalHour,resource,carnet,recurrence,recurrenceDate,status);
                break;
            case MONTHLY:
                createMonthlyReservations(date,initHour,finalHour,resource,carnet,recurrence,recurrenceDate,status);
                break;
        }
    }

    private void createMonthlyReservations(java.sql.Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, RecurrenceOptions recurrence, java.sql.Date recurrenceDate,String status) {
        LocalDate dateLocal=date.toLocalDate();
        for (LocalDate currentDate = dateLocal; currentDate.isBefore(recurrenceDate.toLocalDate().plusDays(1)); currentDate=currentDate.plusMonths(1)) {
            if (currentDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
                reservationDAO.reserveResource(java.sql.Date.valueOf(currentDate),initHour,finalHour,resource,carnet,recurrence,recurrenceDate,status);
            }
        }
    }

    private void createWeeklyReservations(java.sql.Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, RecurrenceOptions recurrence, java.sql.Date recurrenceDate,String status) {
        LocalDate dateLocal=date.toLocalDate();
        for (LocalDate currentDate = dateLocal; currentDate.isBefore(recurrenceDate.toLocalDate().plusDays(1)); currentDate=currentDate.plusDays(7)) {
            if (currentDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
                reservationDAO.reserveResource(java.sql.Date.valueOf(currentDate),initHour,finalHour,resource,carnet,recurrence,recurrenceDate,status);
            }
        }
    }

    private void createDailyReservations(java.sql.Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, RecurrenceOptions recurrence, java.sql.Date recurrenceDate,String status){
        LocalDate dateLocal=date.toLocalDate();
        for (LocalDate currentDate = dateLocal; currentDate.isBefore(recurrenceDate.toLocalDate().plusDays(1)); currentDate=currentDate.plusDays(1)) {
            if (currentDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
                reservationDAO.reserveResource(java.sql.Date.valueOf(currentDate),initHour,finalHour,resource,carnet,recurrence,recurrenceDate,status);
            }
        }
    }

}
