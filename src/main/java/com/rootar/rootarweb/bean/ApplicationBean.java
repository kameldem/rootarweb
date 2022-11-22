package com.rootar.rootarweb.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class ApplicationBean {
    private String base;


    @PostConstruct
    private void iniatilise(){
        base = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
    }
    public String getFaces(){
        return base +"/faces";
    }
}