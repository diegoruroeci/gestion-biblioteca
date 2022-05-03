package edu.eci.cvds.gestor.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import edu.eci.cvds.gestor.persistence.mybatis.mappers.ReservationMapper;
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
    public void reserveResource(Date date, Timestamp initHour, Timestamp finalHour, int resource, int carnet, String recurrence, Date recurrenceDate) {
        try{
            reservationMapper.reserveResource(date,initHour,finalHour,resource,carnet,recurrence,recurrenceDate);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
