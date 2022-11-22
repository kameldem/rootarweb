package com.rootar.rootarweb.bean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("continentBean")
@ApplicationScoped
public class ContinentBean implements Serializable {
    @Inject
    ApplicationBean applicationBean;


}
