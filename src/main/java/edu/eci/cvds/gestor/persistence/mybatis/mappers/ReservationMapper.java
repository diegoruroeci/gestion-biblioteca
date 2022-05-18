package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Reservation;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationMapper {

    public List<Reservation> consultReservations();

    public List<Reservation> consultReservation(@Param("id") int id);

    public List<Reservation> consultReservationsUser(@Param("email") String email);

    public void reserveResource(@Param("fecha") Timestamp date, @Param("horaini") Timestamp initHour, @Param("horafin") Timestamp finalHour, @Param("recurso") int resource, @Param("carnet") int carnet, @Param("recurrencia") String recurrence, @Param("fecharecurrencia") Date recurrenceDate,@Param("estado") String estado);
    public List<Reservation> consultReservationsUserCancelled(@Param("email") String email);

    public List<Reservation> consultReservationsUserExpired(@Param("email") String email);

    public List<Reservation> consultReservationsActive();

    public List<Reservation> consultReservationsActiveByHour(@Param("horaini") Timestamp initHour,@Param("horafin") Timestamp finalHour,@Param("recurso") int resource);

    public List<Reservation> consultReservationsCancelled();

    public List<Reservation> consultReservationsExpired();

    public void reserveResource(@Param("fecha") java.sql.Date date, @Param("horaini") Timestamp initHour, @Param("horafin") Timestamp finalHour, @Param("recurso") int resource, @Param("carnet") int carnet, @Param("recurrencia") String recurrence, @Param("fecharecurrencia") Date recurrenceDate);

    public void cancelReservation( @Param("carnet") int carnet,@Param("horaini") Timestamp initHour,@Param("horafin") Timestamp finalHour,@Param("recurso") int resource);
}
