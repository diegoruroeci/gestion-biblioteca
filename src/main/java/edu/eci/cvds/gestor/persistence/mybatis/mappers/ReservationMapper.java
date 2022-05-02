package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationMapper {

    public List<Reservation> consultReservations();

    public List<Reservation> consultReservationsUser(@Param("email") String email);

    public List<Reservation> consultReservationsUserCancelled(@Param("email") String email);

    public List<Reservation> consultReservationsUserExpired(@Param("email") String email);
}
