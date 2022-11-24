package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Pays;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("paysBean")
@ApplicationScoped
public class PaysBean implements Serializable {
    private Pays paysSelected;
    private ArrayList<Pays> listPays;

    private ArrayList<Pays> listPaysSearch;

    @PostConstruct
    private void init(){
        listPays= DAOFactory.getPaysDAO().getAll();
    }

    public Pays getPaysSelected() {
        return paysSelected;
    }

    public void setPaysSelected(Pays paysSelected) {
        this.paysSelected = paysSelected;
    }

    public ArrayList<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(ArrayList<Pays> listPays) {
        this.listPays = listPays;
    }

    public ArrayList<Pays> getListPaysSearch() {
        return listPaysSearch;
    }

    public void setListPaysSearch(ArrayList<Pays> listPaysSearch) {
        this.listPaysSearch = listPaysSearch;
    }
}
