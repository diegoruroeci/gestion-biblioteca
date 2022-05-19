package edu.eci.cvds.gestor.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.persistence.ResourceDAO;
import edu.eci.cvds.gestor.persistence.mybatis.mappers.ResourceMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public class MyBatisResourceDAO implements ResourceDAO {
    @Inject
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> consultResources() throws PersistenceException {
        try {
            return resourceMapper.consultResources();
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void registerResource(String nombre, String ubicacion, String tipo, int capacidad, int idInterno, String descripcion, boolean disponible) throws ParseException {
        try {
            resourceMapper.registerResource(nombre, ubicacion, tipo, capacidad, idInterno, descripcion, disponible);
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Resource> consultResourcesUser() throws PersistenceException {
        try {
            return resourceMapper.consultResourcesUser();
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Resource consultResource(String id) throws PersistenceException {
        try {
            return resourceMapper.consultResource(id);
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void deleteResource(Resource resource)  throws PersistenceException {
        try{
            resourceMapper.deleteResource(resource);
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void resourceNotAvailable(Resource resource)  throws PersistenceException {
        try{
            resourceMapper.resourceNotAvailable(resource);
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void resourceAvailable(Resource resource)  throws PersistenceException {
        try{
            resourceMapper.resourceAvailable(resource);
        }catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void updateResource(Resource resource){
        try{

            if (resource.getAvailable().equals(true)) {
                resource.setAvailable(false);
            }
            else if (resource.getAvailable().equals(false)){
                resource.setAvailable(true);}
            resourceMapper.updateResource(resource);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }
}