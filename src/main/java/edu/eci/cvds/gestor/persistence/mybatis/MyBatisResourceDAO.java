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
    public List<Resource> consultResources() throws PersistenceException{
        try{
            return resourceMapper.consultResources();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void addResource(Resource recurso) throws PersistenceException {
        try{
            resourceMapper.addResource(recurso);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){

            throw new PersistenceException("Error al registrar recurso: "+recurso.getName(), e);

        }
    }
}
