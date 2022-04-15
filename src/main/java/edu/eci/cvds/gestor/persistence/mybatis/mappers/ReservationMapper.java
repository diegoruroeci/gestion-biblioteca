package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Reservation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservationMapper {

    public List<Reservation> consultReservations();
    public void reserveResource(@Param("reservas") Reservation reservation);
}
