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

public class GuiceContextListener implements ServletContextListener{
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
//                bind(AdminDAO.class).to(MyBatisAdminDAO.class);
//                bind(BoardDAO.class).to(MyBatisBoardDAO.class);
//                bind(BookDAO.class).to(MyBatisBookDAO.class);
//                bind(CommunityDAO.class).to(MyBatisCommunityDAO.class);
//                bind(ComputerDAO.class).to(MyBatisComputerDAO.class);
                bind(ReservationDAO.class).to(MyBatisReservationDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(ResourceDAO.class).to(MyBatisResourceDAO.class);
                bind(GestorServices.class).to(GestorServicesImpl.class);
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}
