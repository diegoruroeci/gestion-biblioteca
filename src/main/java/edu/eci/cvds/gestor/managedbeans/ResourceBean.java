package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.services.GestorServices;
import edu.eci.cvds.gestor.services.UserServices;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="ResourceBean")
@ApplicationScoped
public class ResourceBean extends BasePageBean{


    @Inject
    private UserServices userServices;

    @Inject
    private GestorServices gestorServices;

    public List<Resource> getResources(){
        return gestorServices.consultResources();
    }
}
