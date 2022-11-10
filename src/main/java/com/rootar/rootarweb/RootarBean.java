package com.rootar.rootarweb;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Continent;
import com.rootar.rootarweb.metier.Pays;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@Named("rootarBean")
@SessionScoped
public class RootarBean implements Serializable {
    private Continent continentSelected;
    private ArrayList<Pays> listPays;
    private String nomIMage;
    private ArrayList<Continent> listContinent;
    public RootarBean() {
        continentSelected=new Continent();

    }
    @PostConstruct
    private void init(){



    listContinent=DAOFactory.getContinentDAO().getAll();

    }
    public void show(Continent continent){
        continentSelected=continent;
        listPays=DAOFactory.getPaysDAO().getPaysByContinent(continentSelected.getIdContinent());

    }
    public void buttonAction() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("./payseurope.xhtml");
    }
    public String getNomIMage() {
        return nomIMage;
    }

    public void setNomIMage(String nomIMage) {
        this.nomIMage = nomIMage;
    }

    public Continent getContinentSelected() {
        return continentSelected;
    }

    public void setContinentSelected(Continent continentSelected) {
        this.continentSelected = continentSelected;
    }

    public ArrayList<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(ArrayList<Pays> listPays) {
        this.listPays = listPays;
    }

    public ArrayList<Continent> getListContinent() {
        return listContinent;
    }

    public void setListContinent(ArrayList<Continent> listContinent) {
        this.listContinent = listContinent;
    }
}
