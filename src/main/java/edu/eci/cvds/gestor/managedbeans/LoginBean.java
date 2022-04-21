package edu.eci.cvds.gestor.managedbeans;

import com.google.inject.Inject;
import edu.eci.cvds.gestor.login.LoginServices;
import edu.eci.cvds.gestor.login.LoginServicesImpl;
import edu.eci.cvds.gestor.services.ServicesException;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@ApplicationScoped

public class LoginBean extends BasePageBean {

    @Inject
    private LoginServices loginServices;

    public void singIn(String email, String password, boolean rememberMe) throws ServicesException, IOException {
        try {
            loginServices.singIn(email, password, rememberMe);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/gestor/resource.xhtml");
        }catch (ServicesException servicesException){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",servicesException.getMessage()));
        }
    }

    public String textLog(){
        if(loginServices.isLoggedIn()){
            return "Cerrar Sesión";
        }else {
            return "Iniciar Sesión";
        }
    }
    
    public void actionButton() throws IOException {
        if(loginServices.isLoggedIn()){
            loginServices.logOut();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/gestor/resource.xhtml");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/gestor/login.xhtml");
        }
    }
}
