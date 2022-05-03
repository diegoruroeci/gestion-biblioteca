package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Reservation;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationMapper {

    public List<Reservation> consultReservations();

    public List<Reservation> consultReservationsUser(@Param("email") String email);

    public void reserveResource(@Param("fecha") java.sql.Date date, @Param("horaini") Timestamp initHour, @Param("horafin") Timestamp finalHour, @Param("recurso") int resource, @Param("carnet") int carnet, @Param("recurrencia") String recurrence, @Param("fecharecurrencia") Date recurrenceDate);
}
