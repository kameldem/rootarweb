package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Region;
import com.rootar.rootarweb.metier.Ville;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("villeBean")
@ApplicationScoped
public class VilleBean implements Serializable {

    private Ville villeSelected;
    private ArrayList<Ville> listVille;

    @PostConstruct
    private void init(){
        listVille= DAOFactory.getVilleDAO().getAll();
    }

    public Ville getVilleSelected() {
        return villeSelected;
    }

    public void setVilleSelected(Ville villeSelected) {
        this.villeSelected = villeSelected;
    }

    public ArrayList<Ville> getListVille() {
        return listVille;
    }

    public void setListVille(ArrayList<Ville> listVille) {
        this.listVille = listVille;
    }
}
