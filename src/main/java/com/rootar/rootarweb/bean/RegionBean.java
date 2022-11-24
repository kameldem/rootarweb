package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Region;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("regionBean")
@ApplicationScoped
public class RegionBean implements Serializable {

    private Region regionSelected;
    private ArrayList<Region> listRegion;

    @PostConstruct
    private void init(){
        listRegion= DAOFactory.getRegionDAO().getAll();
    }

    public Region getRegionSelected() {
        return regionSelected;
    }

    public void setRegionSelected(Region regionSelected) {
        this.regionSelected = regionSelected;
    }

    public ArrayList<Region> getListRegion() {
        return listRegion;
    }

    public void setListRegion(ArrayList<Region> listRegion) {
        this.listRegion = listRegion;
    }
}
