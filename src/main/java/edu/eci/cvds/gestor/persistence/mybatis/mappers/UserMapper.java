package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.User;

import java.util.List;

public interface UserMapper {

    public List<User> consultUsers();
}
