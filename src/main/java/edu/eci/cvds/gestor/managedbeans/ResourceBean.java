package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.entities.Resource;
import resource.ResourceService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "resourceBean")
@RequestScoped

public class ResourceBean extends BasePageBean{
    @Inject
    private ResourceService resourceService;
    private String[] tiposDeRecursos = {"Sala de estudio", "Equipo de computo", "Equipo de multimedia", "Libro"};
    private String[] estados = {"Disponible", "No Disponible"};
    private String[] ubicacionDeRecursos = {"Biblioteca Bloque B", "Biblioteca Bloque G"};

    /**
     * Consulta todos los recursos. (Hecho para el administador)
     *
     * @return Lista de todos los recursos
     */
    public List<Resource> consultResources() {
        List<Resource> recursos = new ArrayList<>();
        try {
            recursos = resourceService.consultResources();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recursos;
    }
}
