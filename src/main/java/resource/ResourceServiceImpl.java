package resource;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.persistence.ResourceDAO;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public class ResourceServiceImpl implements ResourceService{
    @Inject
    private
    ResourceDAO resourceDAO;

    @Override
    public void registerResource(Resource resource) throws ParseException {
        try {
            resourceDAO.addResource(resource);
        } catch (PersistenceException  | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
    @Override
    public List<Resource> consultResources() throws PersistenceException {
        try{
            return resourceDAO.consultResources();
        }catch (PersistenceException | ParseException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}
