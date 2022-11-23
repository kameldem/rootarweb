package com.rootar.rootarweb.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@Named
@ApplicationScoped
public class ApplicationBean {
    private String base;
    private String absolutePath;


    @PostConstruct
    private void iniatilise(){
        base = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        /*HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext();
        absolutePath = httpServletRequest.getRequestURL().toString();*/
        System.out.println(absolutePath);
    }
    public String getFaces(){
        return base +"/faces";
    }

    public String getBase() {
        return base;
    }


}