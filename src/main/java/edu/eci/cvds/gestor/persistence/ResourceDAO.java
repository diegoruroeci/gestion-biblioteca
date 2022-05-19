package edu.eci.cvds.gestor.persistence;

import edu.eci.cvds.gestor.entities.Resource;

import java.text.ParseException;
import java.util.List;

public interface ResourceDAO {

    public List<Resource> consultResources() throws ParseException;

    public void registerResource(String nombre, String ubicacion, String tipo, int capacidad, int idInterno, String descripcion, boolean disponible) throws ParseException;

    public List<Resource>  consultResourcesUser() throws ParseException;

    public Resource consultResource(String id) throws ParseException;

    public void deleteResource(Resource resource) throws ParseException;

    public void resourceNotAvailable(Resource resource) throws ParseException;

    public void resourceAvailable(Resource resource) throws ParseException;

}

