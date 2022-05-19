package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    public List<Resource> consultResources();

    public void registerResource(@Param("nombre") String nombre, @Param("ubicacion") String ubicacion, @Param("tipo") String tipo, @Param("capacidad") int capacidad, @Param("idInterno") int idInterno, @Param("descripcion") String descripcion, @Param("disponible") boolean disponible);

    public List<Resource> consultResourcesUser();

    /**
     * Consultar recurso por id
     * @param id identificador del recurso
     * @return el recurso al que corresponde el id
     */
    Resource consultResource(@Param("id") String id);

    /**
     * Elimina un recurso
     * @param resource El recurso a eliminar
     */
    public void deleteResource(@Param("resource") Resource resource);

    /**
     * Cambia la disponibilidad del recurso a false
     * @param resource disponibilidad del recurso false
     */
    public void resourceNotAvailable(@Param("resource") Resource resource);

    /**
     * Cambia la disponibilidad del recurso a true
     * @param resource el recurso
     */
    public void resourceAvailable(@Param("resource") Resource resource);
}
