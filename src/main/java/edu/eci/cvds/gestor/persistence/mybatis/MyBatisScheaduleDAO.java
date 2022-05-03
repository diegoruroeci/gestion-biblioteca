package edu.eci.cvds.gestor.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Reservation;
import edu.eci.cvds.gestor.persistence.ReservationDAO;
import edu.eci.cvds.gestor.persistence.mybatis.mappers.ReservationMapper;

import java.util.List;

public class MyBatisScheaduleDAO implements ReservationDAO {
    @Inject
    private ReservationMapper reservaMapper;

    @Override
    public List<Reservation> consultReservations(){
        return reservaMapper.consultReservations();
    }
}