package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Continent;
import com.rootar.rootarweb.metier.Pays;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@Named("continentBean")
@ApplicationScoped
public class ContinentBean implements Serializable {

    private Continent continentSelected;
    private ArrayList<Continent> listContinent;

    private ArrayList<Pays> listPays;

    public ContinentBean() {
    }

    @PostConstruct
    private void init(){
        listContinent= DAOFactory.getContinentDAO().getAll();
    }

    public void showContinent(Continent continent){
        continentSelected=continent;
        listPays=DAOFactory.getPaysDAO().getPaysByContinent(continentSelected.getIdContinent());

    }

    public void buttonListPays() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("./paysContinents.xhtml");
    }

    public Continent getContinentSelected() {
        return continentSelected;
    }

    public void setContinentSelected(Continent continentSelected) {
        this.continentSelected = continentSelected;
    }

    public ArrayList<Continent> getListContinent() {
        return listContinent;
    }

    public void setListContinent(ArrayList<Continent> listContinent) {
        this.listContinent = listContinent;
    }

    public ArrayList<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(ArrayList<Pays> listPays) {
        this.listPays = listPays;
    }
}
