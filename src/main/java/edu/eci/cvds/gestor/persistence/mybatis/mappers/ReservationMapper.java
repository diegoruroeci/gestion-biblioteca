package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Reservation;

import java.util.List;

public interface ReservationMapper {

    public List<Reservation> consultReservations();
}
