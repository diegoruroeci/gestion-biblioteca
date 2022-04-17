package resource;

import edu.eci.cvds.gestor.entities.Resource;
import org.apache.ibatis.exceptions.PersistenceException;

import java.text.ParseException;
import java.util.List;

public interface ResourceService {

    public void registerResource(Resource resource) throws ParseException;
    public abstract List<Resource> consultResources() throws PersistenceException;
}
