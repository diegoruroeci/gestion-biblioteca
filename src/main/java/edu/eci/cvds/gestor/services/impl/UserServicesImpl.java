package edu.eci.cvds.gestor.services.impl;

import edu.eci.cvds.gestor.services.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


public class UserServicesImpl implements UserServices {
    @Override
    public boolean isAdmin() {
        try {
            Subject subject = SecurityUtils.getSubject();
            return subject.hasRole("A");
        }catch (Exception e){
            return false;
        }
    }
}
