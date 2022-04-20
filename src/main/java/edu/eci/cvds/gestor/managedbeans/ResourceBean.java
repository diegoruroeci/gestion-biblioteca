package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import edu.eci.cvds.gestor.services.GestorServices;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="ResourceBean")
//@RequestScoped
@SessionScoped
//@ApplicationScoped
public class ResourceBean extends BasePageBean{

    @Inject
    private GestorServices gestorServices;

    private List<Resource> filterResource;

    private static ArrayList<Resource> filtroRecurso = new ArrayList<>();

    public List<Resource> getResources(){
        return gestorServices.consultResources();
    }

//    public List<Resource> getResourcesParam(String cadena){
//        return gestorServices.consultResources();
//    }

    public List<Resource> getFilterResource() {
        return filterResource;
    }

    public void setFilterResource(List<Resource> filterResource) {
        this.filterResource = filterResource;
    }

    public ArrayList<Resource> getFiltroRecurso() {
        return filtroRecurso;
    }

    public void setFiltroRecurso(ArrayList<Resource> filtroRecurso) {
        this.filtroRecurso = filtroRecurso;
    }
}
