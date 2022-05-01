package edu.eci.cvds.gestor.services;

import com.google.inject.Injector;
import edu.eci.cvds.gestor.persistence.*;
import edu.eci.cvds.gestor.persistence.mybatis.*;
import edu.eci.cvds.gestor.services.impl.GestorServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;
public class ResourceFactory {
    private static ResourceFactory instance = new ResourceFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ReservationDAO.class).to(MyBatisReservationDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(ResourceDAO.class).to(MyBatisResourceDAO.class);
                bind(GestorServices.class).to(GestorServicesImpl.class);
            }
        });
    }
    private ResourceFactory(){
        optInjector = Optional.empty();
    }

    public GestorServices getGestorServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(GestorServices.class);
    }

    public static ResourceFactory getInstance(){
        return instance;
    }
}
