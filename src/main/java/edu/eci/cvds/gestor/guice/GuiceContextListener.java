package edu.eci.cvds.gestor.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.gestor.persistence.*;
import edu.eci.cvds.gestor.persistence.mybatis.*;
import edu.eci.cvds.gestor.services.GestorServices;
import edu.eci.cvds.gestor.services.impl.GestorServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener {
}
