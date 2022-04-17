package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.Resource;

import java.text.ParseException;
import java.util.List;

public interface ResourceDAO {

    public List<Resource> consultResources() throws ParseException;
    public void addResource(Resource recurso) throws ParseException;

}

