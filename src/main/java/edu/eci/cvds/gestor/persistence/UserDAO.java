package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.User;

import java.text.ParseException;
import java.util.List;

public interface UserDAO {

    public List<User> consultUsers() throws ParseException;
}
