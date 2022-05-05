package edu.eci.cvds.gestor.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import edu.eci.cvds.gestor.persistence.mybatis.mappers.ReservationMapper;
import edu.eci.cvds.gestor.services.RecurrenceOptions;
import org.apache.ibatis.exceptions.PersistenceException;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public class MyBatisReservationDAO implements ReservationDAO {
    @Inject
    private ReservationMapper reservationMapper;

    @Override
    public List<Reservation> consultReservations() throws ParseException {
        try{
            return reservationMapper.consultReservations();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void reserveResource(Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, RecurrenceOptions recurrence, Date recurrenceDate) {
        try{
            reservationMapper.reserveResource(date,initHour,finalHour,resource,carnet,recurrence.toString(),recurrenceDate,"activa");
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsUser(String email) throws PersistenceException{
        try{
            return reservationMapper.consultReservationsUser(email);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultAllReservations() throws PersistenceException{
        try{
            return reservationMapper.consultAllReservations();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    public List<Reservation> consultReservationsUserCancelled(String email) throws PersistenceException {
        try{
            return reservationMapper.consultReservationsUserCancelled(email);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsUserExpired(String email) throws PersistenceException {
        try{
            return reservationMapper.consultReservationsUserExpired(email);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsActive() throws PersistenceException {
        try{
            return reservationMapper.consultReservationsActive();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsCancelled() throws PersistenceException {
        try{
            return reservationMapper.consultReservationsCancelled();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Reservation> consultReservationsExpired() throws PersistenceException {
        try{
            return reservationMapper.consultReservationsExpired();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
