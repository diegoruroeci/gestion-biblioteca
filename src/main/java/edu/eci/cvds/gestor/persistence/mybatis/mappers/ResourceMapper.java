package edu.eci.cvds.gestor.persistence.mybatis.mappers;

import edu.eci.cvds.gestor.entities.Resource;

import java.util.List;

public interface ResourceMapper {
    public List<Resource> consultResources();
}
